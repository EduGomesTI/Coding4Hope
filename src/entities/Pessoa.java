package entities;

import interfaces.IValidarDocumento;
import servicos.CPF;

import java.util.Date;

public abstract class Pessoa extends Entidade  {

    private String nome;
    private String cpf;
    private Date dataNascimento;

    public Pessoa(){}

    public Pessoa(int id, String nome, String cpf, Date dataNascimento) {
        super(id);
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {
        IValidarDocumento validarCPF = new CPF();
        try{
            if(validarCPF.validar(cpf)){
                this.cpf = cpf;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String formatarCPF(String cpf) {
        IValidarDocumento validarCPF = new CPF();
        return validarCPF.formatarComPontos(getCpf());
    }
}
