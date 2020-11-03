package views;

import servicos.Login;

import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TelaMenu extends JFrame {

	private final JButton btnCadastrarUsuario;
	private final JButton btnCadastrarFuncao;
	private final JButton btnCadastrarProd;
	private final JButton btnLivroCaixa;

	private final JButton btnRelatorio1;
	private final JButton btnRelatorio2;
	private final JButton btnRelatorio3;
	private final JButton btnRelatorio4;

	//private JPanel panelButton;
	private final JPanel panelTelaMenu;

	Handler handler = new Handler();

	public TelaMenu() {
		super("Tela de Menu");
		this.setLayout(new BorderLayout());
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);

		// panelButton = new JPanel(new FlowLayout());
		panelTelaMenu = new JPanel(new GridBagLayout());

		GridBagConstraints positions = new GridBagConstraints();
		positions.insets = new Insets(5, 5, 5, 5);

		/* BUTTON */
		positions.anchor = GridBagConstraints.LINE_START;

		positions.gridx = 0;
		positions.gridy = 0;
		btnCadastrarUsuario = new JButton("Cadastrar Usuário");
		btnCadastrarUsuario.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnCadastrarUsuario, positions);
		btnCadastrarUsuario.addActionListener(handler);

		positions.gridx = 0;
		positions.gridy = 1;
		btnCadastrarFuncao = new JButton("Cadastrar Funcionário");
		btnCadastrarFuncao.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnCadastrarFuncao, positions);
		btnCadastrarFuncao.addActionListener(handler);

		positions.gridx = 0;
		positions.gridy = 2;
		btnCadastrarProd = new JButton("Cadastrar Produtos Doados");
		btnCadastrarProd.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnCadastrarProd, positions);
		btnCadastrarProd.addActionListener(handler);

		positions.gridx = 0;
		positions.gridy = 3;
		btnLivroCaixa = new JButton("Livro Caixa");
		btnLivroCaixa.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnLivroCaixa, positions);
		btnLivroCaixa.addActionListener(handler);

		/* BUTTONS - Reports */
		positions.anchor = GridBagConstraints.LINE_END;

		positions.gridx = 1;
		positions.gridy = 0;
		btnRelatorio1 = new JButton("Relatório - Produtos Doados");
		btnRelatorio1.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnRelatorio1, positions);
		btnRelatorio1.addActionListener(handler);

		positions.gridx = 1;
		positions.gridy = 1;
		btnRelatorio2 = new JButton("Relatório - Patrocínios (R$)");
		btnRelatorio2.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnRelatorio2, positions);
		btnRelatorio2.addActionListener(handler);

		positions.gridx = 1;
		positions.gridy = 2;
		btnRelatorio3 = new JButton("Relatório - Patrocinadores");
		btnRelatorio3.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnRelatorio3, positions);
		btnRelatorio3.addActionListener(handler);

		positions.gridx = 1;
		positions.gridy = 3;
		btnRelatorio4 = new JButton("Relatório - Livro Caixa");
		btnRelatorio4.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnRelatorio4, positions);
		btnRelatorio4.addActionListener(handler);

		add(panelTelaMenu, BorderLayout.CENTER);

	}

	public void plotarGraficoProdutos() {
		//Gráfico 'Produtos doados' com legenda
		TelaGraficoProdutos chartProdutos = new TelaGraficoProdutos(
				"Análise Trimestral - Produtos doados",
				"Produtos doados em 2020");
		chartProdutos.pack();
		RefineryUtilities.centerFrameOnScreen(chartProdutos);
		chartProdutos.setVisible(true);
		chartProdutos.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}


	public void plotarGraficoPatrocinios() {
		//Gráfico 'Patrocínios'
		TelaGraficoPatrocinios chartPatrocinios = new TelaGraficoPatrocinios(
				"Análise mensal - Patrocínios",
				"Patrocínios: Out/2020");
		chartPatrocinios.pack();
		RefineryUtilities.centerFrameOnScreen(chartPatrocinios);
		chartPatrocinios.setVisible(true);
		chartPatrocinios.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}


	public void plotarGraficoPatrocinadores() {
		//Gráfico 'Patrocinadores x Meses'
		TelaGraficoPatrocinadores chartPatrocinadores = new TelaGraficoPatrocinadores(
				"Patrocinadores (2020))" ,
				"Patrocinadores x Meses (2020)");
		chartPatrocinadores.pack( );
		RefineryUtilities.centerFrameOnScreen( chartPatrocinadores );
		chartPatrocinadores.setVisible( true );
		chartPatrocinadores.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}


	public static void plotarGraficoLivroCaixa() {
		//Gráfico 'Livro Caixa'
		String tituloDaJanela = "Livro Caixa (2020)";
		TelaGraficoLivroCaixa fluxoCaixa = new TelaGraficoLivroCaixa(tituloDaJanela);
		fluxoCaixa.pack();
		RefineryUtilities.centerFrameOnScreen(fluxoCaixa);
		fluxoCaixa.setVisible(true);
		fluxoCaixa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	/* ACTION - BUTTON */
	public class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (event.toString().contains("Relatório - Produtos Doados")) {
					//gera relatório 1
					plotarGraficoProdutos();

				} else if (event.toString().contains("Relatório - Patrocínios (R$)")) {
					//gera relatório 2
					plotarGraficoPatrocinios();

				} else if (event.toString().contains("Relatório - Patrocinadores")) {
					//gera relatório 3
					plotarGraficoPatrocinadores();

				} else if (event.toString().contains("Relatório - Livro Caixa")) {
					//gera relatório 4
					plotarGraficoLivroCaixa();

					/*String reportInfo = event.getSource().toString();
					String reportName = reportInfo.split("text=")[1].split(",defaultCapable")[0];
					JOptionPane.showMessageDialog(null, reportName + " selecinado com sucesso!");*/

				} else if (event.toString().contains("Cadastrar")) {
					//mostra mensagem de seleção 'Cadastrar' bem-sucedida
					String cadInfo = event.getSource().toString();
					String cadType = cadInfo.split("text=")[1].split(",defaultCapable")[0];
					JOptionPane.showMessageDialog(null, "Opção '" + cadType + "' selecionada com sucesso");

				} else if (event.getSource() == btnLivroCaixa) {
					//mostra mensagem de seleção 'Livro Caixa' bem-sucedida
					JOptionPane.showMessageDialog(null, "Livro Caixa selecionado com sucesso");
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("Ocorreu algum erro na origem do evento!");
			}
		}
	}


	public static void main(String[] args) {
		TelaMenu window = new TelaMenu();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
