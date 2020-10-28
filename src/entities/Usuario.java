package entities;

import java.util.Date;

public class Usuario extends Pessoa{

    private int idPessoa;
    private String email;
    private String senha;
    private Date ultimoLogin;
    private Funcao funcao;

    public Usuario() {
    }

    public Usuario(int id, String nome, String cpf, Date dataNascimento, int idPessoa, String email, String senha, Date ultimoLogin, Funcao funcao) {
        super(id, nome, cpf, dataNascimento);
        this.idPessoa = idPessoa;
        this.email = email;
        this.senha = senha;
        this.ultimoLogin = ultimoLogin;
        this.funcao = funcao;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
}
