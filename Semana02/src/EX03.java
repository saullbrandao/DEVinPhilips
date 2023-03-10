public class EX03  {
    public static void main(String[] args) {
        int[] extrato = { 100, -35, -15, -5, 55, -20 };
        int total = 0;

        System.out.println("Ordem normal");
        for (int j : extrato) {
            System.out.println(j);
            total += j;
        }

        System.out.println("Ordem reversa");
        for (int i = extrato.length - 1; i >= 0; i--) {
            System.out.println(extrato[i]);
        }

        System.out.println("Saldo: " + total);

        String message = total > 0 ? "Saldo positivo" : "Saldo negativo";
        System.out.println(message);
    }
}
