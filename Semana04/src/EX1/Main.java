package EX1;

public class Main {

    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente();

        System.out.println(conta.obterSaldoAtual());
        conta.depositar(10d);
        System.out.println(conta.obterSaldoAtual());
        conta.sacar(15d);
        System.out.println(conta.obterSaldoAtual());
        conta.sacar(5d);
        System.out.println(conta.obterSaldoAtual());

    }

}
