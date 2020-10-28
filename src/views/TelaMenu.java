package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaMenu extends JFrame {

	private JButton btnCadastrarUsuario;
	private JButton btnCadastrarFuncao;
	private JButton btnCadastrarProd;
	private JButton btnLivroCaixa;

	private JButton btnRelatorio1;
	private JButton btnRelatorio2;
	private JButton btnRelatorio3;
	private JButton btnRelatorio4;

	private JPanel panelButton;
	private JPanel panelTelaMenu;

	Handler handler = new Handler();

	public TelaMenu() {
		super("Tela de Menu");
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);

		// panelButton = new JPanel(new FlowLayout());
		panelTelaMenu = new JPanel(new GridBagLayout());

		GridBagConstraints positions = new GridBagConstraints();
		positions.insets = new Insets(5, 5, 5, 5);

		/* BUTTON */
		positions.anchor = positions.LINE_START;

		positions.gridx = 0;
		positions.gridy = 0;
		btnCadastrarUsuario = new JButton("Cadastrar Usuário");
		btnCadastrarUsuario.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnCadastrarUsuario, positions);
		btnCadastrarUsuario.addActionListener(handler);

		positions.gridx = 0;
		positions.gridy = 1;
		btnCadastrarFuncao = new JButton("Cadastrar Função");
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
		positions.anchor = positions.LINE_END;

		positions.gridx = 1;
		positions.gridy = 0;
		btnRelatorio1 = new JButton("Relatório 1 ");
		btnRelatorio1.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnRelatorio1, positions);
		btnRelatorio1.addActionListener(handler);

		positions.gridx = 1;
		positions.gridy = 1;
		btnRelatorio2 = new JButton("Relatório 2");
		btnRelatorio2.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnRelatorio2, positions);
		btnRelatorio2.addActionListener(handler);

		positions.gridx = 1;
		positions.gridy = 2;
		btnRelatorio3 = new JButton("Relatório 3");
		btnRelatorio3.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnRelatorio3, positions);
		btnRelatorio3.addActionListener(handler);

		positions.gridx = 1;
		positions.gridy = 3;
		btnRelatorio4 = new JButton("Relatório 4");
		btnRelatorio4.setPreferredSize(new Dimension(200,25));
		panelTelaMenu.add(btnRelatorio4, positions);
		btnRelatorio4.addActionListener(handler);

		add(panelTelaMenu, BorderLayout.CENTER);

	}

	/* ACTION - BUTTON */
	public class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (event.toString().contains("Relatório")) {
					String reportInfo = event.getSource().toString();
					String reportName = reportInfo.split("text=")[1].split(",defaultCapable")[0];
					JOptionPane.showMessageDialog(null, reportName + " selecinado com sucesso!");

				} else if (event.getSource() == btnCadastrarUsuario) {
					TelaCadastroUsuarios telaCadUsuario = new TelaCadastroUsuarios();
					telaCadUsuario.setDefaultCloseOperation(EXIT_ON_CLOSE);
					telaCadUsuario.setVisible(true);
					dispose();

				} else if (event.getSource() == btnLivroCaixa) {
					TelaLivroCaixa telaLivroCaixa = new TelaLivroCaixa();
					telaLivroCaixa.setDefaultCloseOperation(EXIT_ON_CLOSE);
					telaLivroCaixa.setVisible(true);
					dispose();
				} else if (event.getSource() == btnCadastrarFuncao) {
					TelaCadastroFuncao telaCadastroFuncao = new TelaCadastroFuncao();
					telaCadastroFuncao.setDefaultCloseOperation(EXIT_ON_CLOSE);
					telaCadastroFuncao.setVisible(true);
					dispose();
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
