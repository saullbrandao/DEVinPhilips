package EX4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua idade: ");
        try {
            int idade = scanner.nextInt();
            if (idade > 100) throw new RuntimeException("Idade maior que 100");
            if (idade == 0) throw new RuntimeException("Idade igual a 0");
            if (idade < 0) throw new RuntimeException("Idade negativa");

            System.out.println("Olá, você tem " + idade + " anos de idade!");
        } catch (RuntimeException e) {
            System.out.println(e);
        }

    }
}
