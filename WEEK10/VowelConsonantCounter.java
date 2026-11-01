import java.util.Scanner;

// Class problem 1: input is one alphabetic word; comparison ignores case.
public class VowelConsonantCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toLowerCase(java.util.Locale.ROOT);
        int vowels = 0;
        for (int i = 0; i < word.length(); i++) {
            if ("aeiou".indexOf(word.charAt(i)) >= 0) {
                vowels++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + (word.length() - vowels));
        sc.close();
    }
}
