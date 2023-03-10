public class EX04 {
    public static void main(String[] args) {
        int luckyNumber = 25;
        int count = 0;
        int[][] sorteados = {
                { 1, 44,  6,  2, 45, 60},
                {10, 21, 55, 25, 34, 44},
                { 8, 18, 28, 29, 55, 59},
                {60, 25, 11, 34,  6,  9},
                {55, 43, 25, 12,  7, 11}
        };

        for (int[] sorteado : sorteados) {
            for (int i : sorteado) {
                if (i == luckyNumber) {
                    count += 1;
                }
            }
        }

        System.out.println("Total: " + count);

    }
}
