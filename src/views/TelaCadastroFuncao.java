package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaCadastroFuncao extends JFrame {

	private JTextField inputId;
	private JTextField inputDescricao;
	
	private JCheckBox check;

	private JLabel id;
	private JLabel descricao;
	private JLabel cadastrarUsuario;
	private JLabel cadastrarFuncao;
	private JLabel cadDoacaoProd;
	private JLabel acessLivroCaixa;
	

	private JButton btnInserir;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnCancelar;

	private JPanel panelButton;
	private JPanel panelTelaCadastroFuncao;

	Handler handler = new Handler();

	public TelaCadastroFuncao() {
		super("Tela Cadastro de Usuarios");
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
		id = new JLabel("Id:");
		panelTelaCadastroFuncao.add(id, positions);

		positions.gridx = 0;
		positions.gridy = 1;
		descricao = new JLabel("Descrição:");
		panelTelaCadastroFuncao.add(descricao, positions);

		positions.gridx = 0;
		positions.gridy = 2;
		cadastrarUsuario = new JLabel("Cadastrar Usuário:");
		panelTelaCadastroFuncao.add(cadastrarUsuario, positions);

		positions.gridx = 0;
		positions.gridy = 3;
		cadastrarFuncao = new JLabel("Cadastrar Função:");
		panelTelaCadastroFuncao.add(cadastrarFuncao, positions);

		positions.gridx = 0;
		positions.gridy = 4;
		cadDoacaoProd = new JLabel("Cadastrar Doação de Produtos:");
		panelTelaCadastroFuncao.add(cadDoacaoProd, positions);

		positions.gridx = 0;
		positions.gridy = 5;
		acessLivroCaixa = new JLabel("Acessar Livro Caixa:");
		panelTelaCadastroFuncao.add(acessLivroCaixa, positions);


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
		check = new JCheckBox();
		panelTelaCadastroFuncao.add(check, positions);

		positions.gridx = 1;
		positions.gridy = 3;
		check = new JCheckBox();
		panelTelaCadastroFuncao.add(check, positions);

		positions.gridx = 1;
		positions.gridy = 4;
		check = new JCheckBox();
		panelTelaCadastroFuncao.add(check, positions);

		positions.gridx = 1;
		positions.gridy = 5;
		check = new JCheckBox();
		panelTelaCadastroFuncao.add(check, positions);

		
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

		btnCancelar = new JButton("Cancelar");
		panelButton.add(btnCancelar);
		btnCancelar.addActionListener(handler);

		add(panelTelaCadastroFuncao, BorderLayout.NORTH);
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
				}else if (event.getSource() == btnCancelar) {
					JOptionPane.showMessageDialog(null, "Operação cancelada!");
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

