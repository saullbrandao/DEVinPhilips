public class EX05 {
    public static void main(String[] args) {
        int[] arr1 = {56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47};
        int[] arr2 ={1};
        int[] arr3 ={1, -1};
        int[] arr4 = null;
        int[] arr5 = {-2,-2,-2,-2};
        int[] arr6 = {20,10, 30};

        calcular(arr1);
        calcular(arr2);
        calcular(arr3);
//        calcular(arr4);
        calcular(arr5);
        calcular(arr6);
    }

    private static void calcular(int[] numbers) {
        int lower = Integer.MAX_VALUE;
        int higher = Integer.MIN_VALUE;

        for (int number: numbers) {
            if( number < lower) {
                lower = number;
            }

            if(number > higher) {
                higher = number;
            }
        }

        System.out.println("Menor: " + lower);
        System.out.println("Maior: " + higher);
    }
}
