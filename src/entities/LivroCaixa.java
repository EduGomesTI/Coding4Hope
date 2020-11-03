package entities;

import java.util.Date;

public class LivroCaixa extends Entidade{

    private Date dataOperacao;
    private String operacao;
    private String descricao;
    private double valor;

    public LivroCaixa() {
    }

    public LivroCaixa(int id, Date dataOperacao, String operacao, String descricao, double valor) {
        super(id);
        this.dataOperacao = dataOperacao;
        this.operacao = operacao;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
