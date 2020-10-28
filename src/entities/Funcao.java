package entities;

public class Funcao extends Entidade{

    private String funcao;
    private String cadastrarUsuario;
    private String cadastrarDoacaoProduto;
    private String cadastrarLivroCaixa;
    private String cadastrarFuncao;

    public Funcao() {
    }

    public Funcao(int id, String funcao, String cadastrarUsuario, String cadastrarDoacaoProduto, String cadastrarLivroCaixa, String cadastrarFuncao) {
        super(id);
        this.funcao = funcao;
        this.cadastrarUsuario = cadastrarUsuario;
        this.cadastrarDoacaoProduto = cadastrarDoacaoProduto;
        this.cadastrarLivroCaixa = cadastrarLivroCaixa;
        this.cadastrarFuncao = cadastrarFuncao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public void setCadastrarUsuario(String cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    public String getCadastrarDoacaoProduto() {
        return cadastrarDoacaoProduto;
    }

    public void setCadastrarDoacaoProduto(String cadastrarDoacaoProduto) {
        this.cadastrarDoacaoProduto = cadastrarDoacaoProduto;
    }

    public String getCadastrarLivroCaixa() {
        return cadastrarLivroCaixa;
    }

    public void setCadastrarLivroCaixa(String cadastrarLivroCaixa) {
        this.cadastrarLivroCaixa = cadastrarLivroCaixa;
    }

    public String getCadastrarFuncao() {
        return cadastrarFuncao;
    }

    public void setCadastrarFuncao(String cadastrarFuncao) {
        this.cadastrarFuncao = cadastrarFuncao;
    }
}
