import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EX06 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4);
        List<Integer> newList = new ArrayList<>();

        lista.forEach(number -> newList.add(number * 3));

        System.out.println(newList);
    }
}
