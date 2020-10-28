package interfaces;

public interface IValidarDocumento {

    boolean validar(String doc);

    String formatarComPontos(String doc);

    String formatarSemPontos(String doc);
}
