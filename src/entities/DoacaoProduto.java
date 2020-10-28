package entities;

public class DoacaoProduto extends Entidade {

    private String descricaoDoacao;
    private Double valorDoacao;
    //TODO Lógica da imagem do produto


    public DoacaoProduto() {
    }

    public DoacaoProduto(int id, String descricaoDoacao, Double valorDoacao) {
        super(id);
        this.descricaoDoacao = descricaoDoacao;
        this.valorDoacao = valorDoacao;
    }

    public String getDescricaoDoacao() {
        return descricaoDoacao;
    }

    public void setDescricaoDoacao(String descricaoDoacao) {
        this.descricaoDoacao = descricaoDoacao;
    }

    public Double getValorDoacao() {
        return valorDoacao;
    }

    public void setValorDoacao(Double valorDoacao) {
        this.valorDoacao = valorDoacao;
    }
}
