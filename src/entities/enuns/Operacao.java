package entities.enuns;

public enum Operacao {
    Entrada("E"),
    Saida("S");

    private String tipo;

    private Operacao(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
