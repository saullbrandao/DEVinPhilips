import java.util.Arrays;
import java.util.List;

public class EX07 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("kirk", "spock", "scott", "mccoy", "sulu");

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));

        }

        nomes.forEach(nome -> System.out.println(nome));

        int count = 0;
        while (count < nomes.size()) {
            System.out.println(nomes.get(count));
            count++;
        }
    }
}
