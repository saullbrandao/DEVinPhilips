package EX3;

public class Produto implements Tributavel {
    double valor;
    double valorImposto;

    @Override
    public double calcularValorImposto() {
        return valor + valorImposto;
    }
}
