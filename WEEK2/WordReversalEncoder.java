import java.util.Scanner;
public class WordReversalEncoder {
    public String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
            // process every word in the sentence
        for (int i = 0; i < words.length; i++) {
            // reverse the current word
            StringBuilder reversedWord = new StringBuilder();
               // append the reversed word to the result
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversedWord.append(words[i].charAt(j));
            }
            
            result.append(reversedWord);
            // append a space after each word except the last one
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        WordReversalEncoder obj = new WordReversalEncoder();
        String reversedSentence = obj.reverseEachWord(sentence);
        System.out.println("Reversed sentence: " + reversedSentence);
        
        sc.close();
    }
}