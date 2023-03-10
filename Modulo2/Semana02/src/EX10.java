public class EX10 {
    public static void main(String[] args) {
        System.out.println("osso: " + isPalindrome("osso"));
        System.out.println("ana: " + isPalindrome("ana"));
        System.out.println("radar: " + isPalindrome("radar"));
        System.out.println("nada: " + isPalindrome("nada"));
    }

    public static  boolean isPalindrome(String word) {
        String reverseWord = "";

        for (int i = word.length() - 1; i >=0 ; i--) {
            reverseWord += word.charAt(i);
        }

        return word.equalsIgnoreCase(reverseWord);
    }
}
