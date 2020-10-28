package views;

import servicos.Login;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {

	private JTextField inputEmail;
	private JTextField inputSenha;

	private JLabel email;
	private JLabel senha;

	private JButton btnLogin;
	private JButton btnSair;
	private JButton btnAlterarSenha;

	private JPanel panelButton;
	private JPanel panelTelaLogin;

	Handler handler = new Handler();


	public TelaLogin() {
		super("Tela Login");
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);

		panelButton = new JPanel(new FlowLayout());
		panelTelaLogin = new JPanel(new GridBagLayout());

		GridBagConstraints positions = new GridBagConstraints();
		positions.insets = new Insets(3, 0, 3, 0);

		/* LABEL: Email and password */
		positions.anchor = positions.LINE_START;

		positions.gridx = 0;
		positions.gridy = 0;
		email = new JLabel("E-mail:");
		panelTelaLogin.add(email, positions);

		positions.gridx = 0;
		positions.gridy = 1;
		senha = new JLabel("Senha:");
		panelTelaLogin.add(senha, positions);

		/* INPUT: Email and password */
		positions.anchor = positions.LINE_END;

		positions.gridx = 1;
		positions.gridy = 0;
		inputEmail = new JTextField(10);
		panelTelaLogin.add(inputEmail, positions);

		positions.gridx = 1;
		positions.gridy = 1;
		inputSenha = new JTextField(10);
		panelTelaLogin.add(inputSenha, positions);

		/* BUTTONS */

		btnLogin = new JButton("Login");
		panelButton.add(btnLogin);
		/* Add logic validation success */
		btnLogin.addActionListener(handler);

		btnSair = new JButton("Sair");
		panelButton.add(btnSair);
		btnSair.addActionListener(handler);

		btnAlterarSenha = new JButton("Esqueci a senha");
		panelButton.add(btnAlterarSenha);
		btnAlterarSenha.addActionListener(handler);

		add(panelTelaLogin, BorderLayout.NORTH);
		add(panelButton, BorderLayout.CENTER);

	}

	
	/*ACTION - BUTTON*/
	public class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (event.getSource() == btnLogin) {
					Login login = new Login();
					if(login.isLogin(inputEmail.getText(), inputSenha.getText())) {
						TelaMenu telaMenu = new TelaMenu();
						telaMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
						telaMenu.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "E-mail ou senha incorreto.");
					}
				} else if (event.getSource() == btnSair) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (opcao == 0) {
						dispose();
					}
				} else if (event.getSource() == btnAlterarSenha) {
					TelaAlterarSenha telaAlterarSenha = new TelaAlterarSenha();
					telaAlterarSenha.setDefaultCloseOperation(EXIT_ON_CLOSE);
					telaAlterarSenha.setVisible(true);
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("Ocorreu algum erro na origem do evento!");
			}
		}
	}

	public static void main(String[] args) {
		TelaLogin telaLogin = new TelaLogin();
		telaLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
		telaLogin.setVisible(true);

	}

}
