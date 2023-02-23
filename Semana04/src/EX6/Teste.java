package EX6;

public class Teste {
    public void validar(String valorCampo, Integer valorMaximoCampo) throws TamanhoInvalidoException, IllegalArgumentException {
        if(valorCampo == null || valorMaximoCampo == null || valorMaximoCampo < 0) {
            throw new IllegalArgumentException();
        }

        if(valorCampo.length() > valorMaximoCampo) {
            throw new TamanhoInvalidoException("Tamanho inválido");
        }
    }
}
