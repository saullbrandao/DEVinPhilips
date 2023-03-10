package EX6;

public class Main {
    public static void main(String[] args) {
        Teste teste = new Teste();

        try {
            teste.validar("abc", 1);
        } catch (IllegalArgumentException | TamanhoInvalidoException exception) {
            System.out.println(exception);
        }
    }
}
