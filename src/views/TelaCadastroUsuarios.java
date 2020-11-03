package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaCadastroUsuarios extends JFrame {

	private JTextField inputId;
	private JTextField inputNome;
	private JTextField inputCPF;
	private JTextField inputDataNascimento;
	private JTextField inputEmail;
	private JTextField inputNovaSenha;
	private JTextField inputRepetirSenha;

	private JLabel id;
	private JLabel nome;
	private JLabel cpf;
	private JLabel dataNascimento;
	private JLabel email;
	private JLabel novaSenha;
	private JLabel repetirSenha;

	private JButton btnInserir;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnCancelar;

	private JPanel panelButton;
	private JPanel panelTelaCadastroUsuarios;

	Handler handler = new Handler();

	public TelaCadastroUsuarios() {
		super("Tela Cadastro de Usuarios");
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);

		panelButton = new JPanel(new FlowLayout());
		panelTelaCadastroUsuarios = new JPanel(new GridBagLayout());

		GridBagConstraints positions = new GridBagConstraints();
		positions.insets = new Insets(4, 2, 4, 2);

		/* LABEL */
		positions.anchor = positions.LINE_START;

		positions.gridx = 0;
		positions.gridy = 0;
		id = new JLabel("Id:");
		panelTelaCadastroUsuarios.add(id, positions);

		positions.gridx = 0;
		positions.gridy = 1;
		nome = new JLabel("Nome:");
		panelTelaCadastroUsuarios.add(nome, positions);

		positions.gridx = 0;
		positions.gridy = 2;
		cpf = new JLabel("CPF:");
		panelTelaCadastroUsuarios.add(cpf, positions);

		positions.gridx = 0;
		positions.gridy = 3;
		dataNascimento = new JLabel("Data Nascimento:");
		panelTelaCadastroUsuarios.add(dataNascimento, positions);

		positions.gridx = 0;
		positions.gridy = 4;
		email = new JLabel("E-mail:");
		panelTelaCadastroUsuarios.add(email, positions);

		positions.gridx = 0;
		positions.gridy = 5;
		novaSenha = new JLabel("Nova senha:");
		panelTelaCadastroUsuarios.add(novaSenha, positions);

		positions.gridx = 0;
		positions.gridy = 6;
		repetirSenha = new JLabel("Repetir Senha:");
		panelTelaCadastroUsuarios.add(repetirSenha, positions);

		/* INPUT */
		positions.anchor = positions.LINE_END;

		positions.gridx = 1;
		positions.gridy = 0;
		inputId = new JTextField(10);
		panelTelaCadastroUsuarios.add(inputId, positions);

		positions.gridx = 1;
		positions.gridy = 1;
		inputNome = new JTextField(10);
		panelTelaCadastroUsuarios.add(inputNome, positions);

		positions.gridx = 1;
		positions.gridy = 2;
		inputCPF = new JTextField(10);
		panelTelaCadastroUsuarios.add(inputCPF, positions);

		positions.gridx = 1;
		positions.gridy = 3;
		inputDataNascimento = new JTextField(10);
		panelTelaCadastroUsuarios.add(inputDataNascimento, positions);

		positions.gridx = 1;
		positions.gridy = 4;
		inputEmail = new JTextField(10);
		panelTelaCadastroUsuarios.add(inputEmail, positions);

		positions.gridx = 1;
		positions.gridy = 5;
		inputNovaSenha = new JTextField(10);
		panelTelaCadastroUsuarios.add(inputNovaSenha, positions);

		positions.gridx = 1;
		positions.gridy = 6;
		inputRepetirSenha = new JTextField(10);
		panelTelaCadastroUsuarios.add(inputRepetirSenha, positions);

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

		add(panelTelaCadastroUsuarios, BorderLayout.NORTH);
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
		TelaCadastroUsuarios window = new TelaCadastroUsuarios();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}
