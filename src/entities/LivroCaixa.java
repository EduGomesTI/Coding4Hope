package entities;

import entities.enuns.Operacao;

import java.util.Date;

public class LivroCaixa extends Entidade{

    private Date dataOperacao;
    private Operacao operacao;
    private String descricao;
    private double valor;

    public LivroCaixa() {
    }

    public LivroCaixa(int id, Date dataOperacao, Operacao operacao, String descricao, double valor) {
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

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
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
