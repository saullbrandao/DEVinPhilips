import java.util.Arrays;
import java.util.List;

public class EX08 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(0, 2, 88, 56, 33, 42, 67, 3, 9, 0, 2);

        for (int numero : numeros) {
            if(numero > 50) {
                System.out.println(numero);
                return;
            }
        }
    }
}
