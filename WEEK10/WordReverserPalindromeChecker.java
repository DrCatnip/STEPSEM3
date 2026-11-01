import java.util.Scanner;

// Class problem 2: input is one word. Palindrome comparison is case-sensitive.
public class WordReverserPalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String reversed = new StringBuilder(word).reverse().toString();
        String result = word.equals(reversed) ? "palindrome" : "not a palindrome";
        System.out.println(reversed + " - " + result);
        sc.close();
    }
}
