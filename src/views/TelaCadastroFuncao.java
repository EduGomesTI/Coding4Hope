package views;

import dao.FuncaoDAO;
import entities.Funcao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class TelaCadastroFuncao extends JFrame {

	private JTextField inputId;
	private JTextField inputDescricao;
	
	private JCheckBox checkUsuario;
	private JCheckBox checkDoacaoProduto;
	private JCheckBox checkLivroCaixa;
	private JCheckBox checkFuncao;

	private JLabel lblId;
	private JLabel lblDescricao;
	private JLabel lblCadastrarUsuario;
	private JLabel lblCadastrarFuncao;
	private JLabel lblCadDoacaoProd;
	private JLabel lblAcessLivroCaixa;
	

	private JButton btnInserir;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnVoltar;

	private JPanel panelButton;
	private JPanel panelTelaCadastroFuncao;

	private JTable tableData;

	Handler handler = new Handler();

	public TelaCadastroFuncao() {
		super("Tela Cadastro de Funções de Usuários");
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);

		panelButton = new JPanel(new FlowLayout());
		panelTelaCadastroFuncao = new JPanel(new GridBagLayout());


		GridBagConstraints positions = new GridBagConstraints();
		positions.insets = new Insets(4, 2, 4, 2);

		/* LABEL */
		positions.anchor = positions.LINE_START;

		positions.gridx = 0;
		positions.gridy = 0;
		lblId = new JLabel("Id:");
		panelTelaCadastroFuncao.add(lblId, positions);

		positions.gridx = 0;
		positions.gridy = 1;
		lblDescricao = new JLabel("Descrição:");
		panelTelaCadastroFuncao.add(lblDescricao, positions);

		positions.gridx = 0;
		positions.gridy = 2;
		lblCadastrarUsuario = new JLabel("Cadastrar Usuário:");
		panelTelaCadastroFuncao.add(lblCadastrarUsuario, positions);

		positions.gridx = 0;
		positions.gridy = 3;
		lblCadastrarFuncao = new JLabel("Cadastrar Função:");
		panelTelaCadastroFuncao.add(lblCadastrarFuncao, positions);

		positions.gridx = 0;
		positions.gridy = 4;
		lblCadDoacaoProd = new JLabel("Cadastrar Doação de Produtos:");
		panelTelaCadastroFuncao.add(lblCadDoacaoProd, positions);

		positions.gridx = 0;
		positions.gridy = 5;
		lblAcessLivroCaixa = new JLabel("Acessar Livro Caixa:");
		panelTelaCadastroFuncao.add(lblAcessLivroCaixa, positions);


		/* INPUT and CHECKBOX */
		positions.anchor = positions.LINE_END;

		positions.gridx = 1;
		positions.gridy = 0;
		inputId = new JTextField(10);
		panelTelaCadastroFuncao.add(inputId, positions);

		positions.gridx = 1;
		positions.gridy = 1;
		inputDescricao = new JTextField(10);
		panelTelaCadastroFuncao.add(inputDescricao, positions);

		positions.gridx = 1;
		positions.gridy = 2;
		checkUsuario = new JCheckBox();
		panelTelaCadastroFuncao.add(checkUsuario, positions);

		positions.gridx = 1;
		positions.gridy = 3;
		checkFuncao = new JCheckBox();
		panelTelaCadastroFuncao.add(checkFuncao, positions);

		positions.gridx = 1;
		positions.gridy = 4;
		checkDoacaoProduto = new JCheckBox();
		panelTelaCadastroFuncao.add(checkDoacaoProduto, positions);

		positions.gridx = 1;
		positions.gridy = 5;
		checkLivroCaixa = new JCheckBox();
		panelTelaCadastroFuncao.add(checkLivroCaixa, positions);

		
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

		ArrayList<Funcao> funcoes;
		FuncaoDAO funcaoDAO = new FuncaoDAO();
		funcoes = funcaoDAO.retornarTodos();
		String[][] data = new String[funcoes.size()][6];

		for(int i = 0; i< funcoes.size();i++){
			data[i][0] = String.valueOf(funcoes.get(i).getId());
			data[i][1] = String.valueOf(funcoes.get(i).getFuncao());
			data[i][2] = String.valueOf(funcoes.get(i).getCadastrarUsuario());
			data[i][3] = String.valueOf(funcoes.get(i).getCadastrarDoacaoProduto());
			data[i][4] = String.valueOf(funcoes.get(i).getCadastrarFuncao());
			data[i][5] = String.valueOf(funcoes.get(i).getCadastrarLivroCaixa());
		}

		String[] columName = {"Função ID", "Descrição", "Cad. Usuário?", "Cad. Doações?", "Cad. Funções?", "Acessar Livro Caixa?"};

		tableData = new JTable(data, columName);
		tableData.setBounds(30, 40, 400, 400);
		JScrollPane sp = new JScrollPane(tableData);
		panelButton.add(sp);

		add(panelTelaCadastroFuncao, BorderLayout.NORTH);
		add(panelButton, BorderLayout.CENTER);


	}

	/* ACTION - BUTTON */
	public class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (event.getSource() == btnInserir) {

					Funcao funcao = new Funcao();

					funcao.setFuncao(inputDescricao.getText());

					if(checkDoacaoProduto.isSelected()){
						funcao.setCadastrarDoacaoProduto("S");
					}else{
						funcao.setCadastrarDoacaoProduto("N");
					}
					if(checkFuncao.isSelected()){
						funcao.setCadastrarFuncao("S");
					}else{
						funcao.setCadastrarFuncao("N");
					}
					if(checkLivroCaixa.isSelected()){
						funcao.setCadastrarLivroCaixa("S");
					}else{
						funcao.setCadastrarLivroCaixa("N");
					}
					if(checkUsuario.isSelected()){
						funcao.setCadastrarUsuario("S");
					}else{
						funcao.setCadastrarUsuario("N");
					}
					FuncaoDAO funcaoDAO = new FuncaoDAO();

					funcaoDAO.inserir(funcao);

					JOptionPane.showMessageDialog(null, "Função inserida com sucesso.");

				} else if (event.getSource() == btnPesquisar) {

					Funcao funcao = new Funcao();

					funcao.setId(Integer.parseInt(inputId.getText()));

					if(funcao.getId() != 0) {

						FuncaoDAO funcaoDAO = new FuncaoDAO();
						funcaoDAO.localizar(funcao);

						inputDescricao.setText(funcao.getFuncao());

						if (funcao.getCadastrarDoacaoProduto().equals("S")) {
							checkDoacaoProduto.setSelected(true);
						} else {
							checkDoacaoProduto.setSelected(false);
						}

						if ((funcao.getCadastrarFuncao().equals("S"))) {
							checkFuncao.setSelected(true);
						} else {
							checkFuncao.setSelected(false);
						}

						if(funcao.getCadastrarLivroCaixa().equals("S")){
							checkLivroCaixa.setSelected(true);
						}else{
							checkLivroCaixa.setSelected(false);
						}

						if(funcao.getCadastrarUsuario().equals("S")){
							checkUsuario.setSelected(true);
						}else{
							checkUsuario.setSelected(false);
						}

					}else{
						JOptionPane.showMessageDialog(null, "O campo ID não poed ficar vazio.");
					}

				} else if (event.getSource() == btnAlterar) {

					Funcao funcao = new Funcao();

					if (inputId.getText() != "") {

						funcao.setId(Integer.parseInt(inputId.getText()));

						funcao.setFuncao(inputDescricao.getText());

						if (checkDoacaoProduto.isSelected()) {
							funcao.setCadastrarDoacaoProduto("S");
						} else {
							funcao.setCadastrarDoacaoProduto("N");
						}
						if (checkFuncao.isSelected()) {
							funcao.setCadastrarFuncao("S");
						} else {
							funcao.setCadastrarFuncao("N");
						}
						if (checkLivroCaixa.isSelected()) {
							funcao.setCadastrarLivroCaixa("S");
						} else {
							funcao.setCadastrarLivroCaixa("N");
						}
						if (checkUsuario.isSelected()) {
							funcao.setCadastrarUsuario("S");
						} else {
							funcao.setCadastrarUsuario("N");
						}
						FuncaoDAO funcaoDAO = new FuncaoDAO();

						funcaoDAO.alterar(funcao);

						JOptionPane.showMessageDialog(null, "Função alterada com sucesso.");
					} else {
						JOptionPane.showMessageDialog(null, "O campo ID não pode ficar vazio.");
					}




				} else if (event.getSource() == btnExcluir) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este usuário?", "Excluir",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

					if (opcao == 0) {

						if (inputId.getText() != ""){

							Funcao funcao = new Funcao();

							funcao.setId(Integer.parseInt(inputId.getText()));

							FuncaoDAO funcaoDAO = new FuncaoDAO();

							funcaoDAO.remover(funcao);

							JOptionPane.showMessageDialog(null, "Função excluída com sucesso!");

						}else{
							JOptionPane.showMessageDialog(null, "O campo ID não pode ficar vazio");
						}


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
		TelaCadastroFuncao window = new TelaCadastroFuncao();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}

