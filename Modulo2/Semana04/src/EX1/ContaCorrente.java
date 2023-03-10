package EX1;

public class ContaCorrente extends Conta implements Operavel{
    @Override
    protected double obterSaldoAtual() {
        return this.saldo;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        double result = this.saldo - valor;
        if(result < 0) {
            System.out.println("Saldo insuficiente para realizar essa operação.");
            return;
        }

        this.saldo = result;
    }
}
