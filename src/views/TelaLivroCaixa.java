package views;

import dao.FuncaoDAO;
import dao.LivroCaixaDAO;
import entities.Funcao;
import entities.LivroCaixa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class TelaLivroCaixa extends JFrame {

	private JTextField inputData;
	private JTextField inputOperacao;
	private JTextField inputDescricao;
	private JTextField inputValor;
	
	private JLabel lbldata;
	private JLabel lbldescricao;
	private JLabel lbloperacao;
	private JLabel lblvalor;
	
	private JButton btnInserir;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnVoltar;

	private JPanel panelButton;
	private JPanel panelTelaLivroCaixa;

	private JTable tableData;

	Handler handler = new Handler();

	public TelaLivroCaixa() {
		super("Livro-Caixa");
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);

		panelButton = new JPanel(new FlowLayout());
		panelTelaLivroCaixa = new JPanel(new GridBagLayout());

		GridBagConstraints positions = new GridBagConstraints();
		positions.insets = new Insets(4, 2, 4, 2);

		/* LABEL */
		positions.anchor = positions.LINE_START;

		positions.gridx = 0;
		positions.gridy = 0;
		lbldata = new JLabel("Data:");
		panelTelaLivroCaixa.add(lbldata, positions);

		positions.gridx = 0;
		positions.gridy = 1;
		lbloperacao = new JLabel("Operação (E/S): ");
		panelTelaLivroCaixa.add(lbloperacao, positions);

		positions.gridx = 0;
		positions.gridy = 2;
		lbldescricao = new JLabel("Descrição: ");
		panelTelaLivroCaixa.add(lbldescricao, positions);

		positions.gridx = 0;
		positions.gridy = 3;
		lblvalor = new JLabel("Valor: ");
		panelTelaLivroCaixa.add(lblvalor, positions);

		/* INPUT */
		positions.anchor = positions.LINE_END;

		positions.gridx = 1;
		positions.gridy = 0;
		inputData = new JTextField(10);
		panelTelaLivroCaixa.add(inputData, positions);

		positions.gridx = 1;
		positions.gridy = 1;
		inputOperacao = new JTextField(10);
		panelTelaLivroCaixa.add(inputOperacao, positions);

		positions.gridx = 1;
		positions.gridy = 2;
		inputDescricao = new JTextField(10);
		panelTelaLivroCaixa.add(inputDescricao, positions);

		positions.gridx = 1;
		positions.gridy = 3;
		inputValor = new JTextField(10);
		panelTelaLivroCaixa.add(inputValor, positions);

		
		/* BUTTONS */

		btnInserir = new JButton("Inserir");
		panelButton.add(btnInserir);
		btnInserir.addActionListener(handler);

		btnPesquisar = new JButton("Pesquisar");
		panelButton.add(btnPesquisar);
		btnPesquisar.addActionListener(handler);

		btnAlterar = new JButton("Alterar");
		panelButton.add(btnAlterar);
		btnAlterar.addActionListener(handler);

		btnExcluir = new JButton("Excluir");
		panelButton.add(btnExcluir);
		btnExcluir.addActionListener(handler);

		btnVoltar = new JButton("Voltar");
		panelButton.add(btnVoltar);
		btnVoltar.addActionListener(handler);

		ArrayList<LivroCaixa> livroCaixas;
		LivroCaixaDAO livroCaixaDAO = new LivroCaixaDAO();
		livroCaixas = livroCaixaDAO.retornarTodos();
		String[][] data = new String[livroCaixas.size()][5];

		for(int i = 0; i< livroCaixas.size();i++){
			data[i][0] = String.valueOf(livroCaixas.get(i).getId());
			data[i][1] = String.valueOf(livroCaixas.get(i).getDataOperacao());
			data[i][2] = String.valueOf(livroCaixas.get(i).getOperacao());
			data[i][3] = String.valueOf(livroCaixas.get(i).getDescricao());
			data[i][4] = String.valueOf(livroCaixas.get(i).getValor());
		}

		String[] columName = {"Operação ID", "Data", "Entrada/Saída", "Descrição", "Valor"};

		tableData = new JTable(data, columName);
		tableData.setBounds(30, 40, 400, 400);
		JScrollPane sp = new JScrollPane(tableData);
		panelButton.add(sp);

		add(panelTelaLivroCaixa, BorderLayout.NORTH);
		add(panelButton, BorderLayout.CENTER);

	}

	/* ACTION - BUTTON */
	public class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (event.getSource() == btnInserir) {
					JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso.");
				} else if (event.getSource() == btnPesquisar) {
					JOptionPane.showMessageDialog(null, "Pesquisa está sendo realizada...Aguarde", "Pesquisando...",
							JOptionPane.WARNING_MESSAGE);
				} else if (event.getSource() == btnAlterar) {
					JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
				} else if (event.getSource() == btnExcluir) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este usuário?", "Excluir",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

					if (opcao == 0) {
						JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
					}
				}else if (event.getSource() == btnVoltar) {
					TelaMenu telaMenu = new TelaMenu();
					telaMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
					telaMenu.setVisible(true);
					dispose();
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("Ocorreu algum erro na origem do evento!");
			}
		}
	}

	public static void main(String[] args) {
		TelaLivroCaixa window = new TelaLivroCaixa();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}

