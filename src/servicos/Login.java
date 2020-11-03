package servicos;

import dao.LoginDAO;
import dao.UsuarioDAO;
import entities.Usuario;
import interfaces.IValidarDocumento;

import javax.swing.*;

public class Login {

    Usuario user = new Usuario();

    LoginDAO LoginDAO = new LoginDAO();

    public boolean isLogin(String email, String senha){

        user = LoginDAO.login(email, senha);

        return user.getId() != 0;

    }

    private boolean isLoginComCPF(String cpf, String email){

        IValidarDocumento _cpf = new CPF();

        user = LoginDAO.loginComCPF(_cpf.formatarSemPontos(cpf), email);

        return user.getId() != 0;
    }

    public boolean alterarSenha(String novaSenha, String repetirSenha, String cpf, String email){


        //Verifica se as senhas digitadas são iguais
        if(isSenhasIguais(novaSenha, repetirSenha)){

            //Verifica se existe um usuário com este CPF e Data de Nascimento
            if(isLoginComCPF(cpf, email)){

                //Realiza a alteração da senha
                user.setSenha(novaSenha);
               // user.setCpf(cpf);
                LoginDAO.alterarSenha(user);
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "CPF ou E-mail não encontrados.");
                return false;
            }

        } else {
                JOptionPane.showMessageDialog(null, "As senha não conferem. Favor verificar.");
                return false;
        }

    }

    private boolean isSenhasIguais(String novaSenha, String repetirSenha){

        String _novaSenha = novaSenha.trim();
        String _repetirSenha = repetirSenha.trim();
        boolean saoIguais = false;

        if(!_novaSenha.equals("")){
            if(_novaSenha.equals(_repetirSenha)){
                saoIguais = true;
            }
        }
        return saoIguais;

    }

}
