package views;

import servicos.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaAlterarSenha extends JFrame {

	private JTextField inputCPF;
	private JTextField inputemail;
	private JTextField inputNovaSenha;
	private JTextField inputRepetirSenha;

	private JLabel cpf;
	private JLabel email;
	private JLabel novaSenha;
	private JLabel repetirSenha;

	private JButton btnAlterarSenha;
	private JButton btnVoltar;

	private JPanel panelButton;
	private JPanel panelTelaAlterarSenha;

	Handler handler = new Handler();

	public TelaAlterarSenha() {
		super("Tela Alterar Senha");
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);

		panelButton = new JPanel(new FlowLayout());
		panelTelaAlterarSenha = new JPanel(new GridBagLayout());

		GridBagConstraints positions = new GridBagConstraints();
		positions.insets = new Insets(4, 2, 4, 2);

		/* LABEL */
		positions.anchor = positions.LINE_START;

		positions.gridx = 0;
		positions.gridy = 0;
		cpf = new JLabel("CPF:");
		panelTelaAlterarSenha.add(cpf, positions);

		positions.gridx = 0;
		positions.gridy = 1;
		email = new JLabel("E-mail:");
		panelTelaAlterarSenha.add(email, positions);

		positions.gridx = 0;
		positions.gridy = 2;
		novaSenha = new JLabel("Nova senha:");
		panelTelaAlterarSenha.add(novaSenha, positions);

		positions.gridx = 0;
		positions.gridy = 3;
		repetirSenha = new JLabel("Repetir Senha:");
		panelTelaAlterarSenha.add(repetirSenha, positions);

		/* INPUT */
		positions.anchor = positions.LINE_END;

		positions.gridx = 1;
		positions.gridy = 0;
		inputCPF = new JTextField(10);
		panelTelaAlterarSenha.add(inputCPF, positions);

		positions.gridx = 1;
		positions.gridy = 1;
		inputemail = new JTextField(10);
		panelTelaAlterarSenha.add(inputemail, positions);

		positions.gridx = 1;
		positions.gridy = 2;
		inputNovaSenha = new JTextField(10);
		panelTelaAlterarSenha.add(inputNovaSenha, positions);

		positions.gridx = 1;
		positions.gridy = 3;
		inputRepetirSenha = new JTextField(10);
		panelTelaAlterarSenha.add(inputRepetirSenha, positions);

		/* BUTTONS */

		btnAlterarSenha = new JButton("Alterar senha");
		panelButton.add(btnAlterarSenha);
		btnAlterarSenha.addActionListener(handler);

		btnVoltar = new JButton("Voltar");
		panelButton.add(btnVoltar);
		btnVoltar.addActionListener(handler);

		add(panelTelaAlterarSenha, BorderLayout.NORTH);
		add(panelButton, BorderLayout.CENTER);

	}

	/* ACTION - BUTTON */
	public class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (event.getSource() == btnAlterarSenha) {
					Login login = new Login();
					if(login.alterarSenha(inputNovaSenha.getText(), inputRepetirSenha.getText(), inputCPF.getText(), inputemail.getText())){
						JOptionPane.showMessageDialog(null, "Senha alterado com sucesso!");
					}
					dispose();

				} else if (event.getSource() == btnVoltar) {
					dispose();
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("Ocorreu algum erro na origem do evento!");
			}
		}
	}

	public static void main(String[] args) {
		TelaAlterarSenha window = new TelaAlterarSenha();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}
