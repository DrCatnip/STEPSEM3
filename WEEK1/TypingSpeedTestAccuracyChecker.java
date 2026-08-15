import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    // Method to check typing accuracy
    public void checkTypingAccuracy(String original, String typed) {

        int matchedCharacters = 0;
        int firstMismatch = -1;

        // Compare both strings character by character
        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {

                matchedCharacters++;

            } else if (firstMismatch == -1) {

                // Store the position of the first mistake
                firstMismatch = i;
            }
        }

        // Calculate accuracy percentage
        double accuracy =
                ((double) matchedCharacters / original.length()) * 100;

        System.out.println("\nTyping Accuracy Result:");
        System.out.println("Matched: "
                + matchedCharacters
                + "/"
                + original.length());

        // Print accuracy with two decimal places
        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        // Display first mismatch
        if (firstMismatch == -1) {

            System.out.println("No Mismatches");

        } else {

            System.out.println(
                    "First Mismatch at position "
                            + (firstMismatch + 1)
                            + " ('"
                            + original.charAt(firstMismatch)
                            + "' vs '"
                            + typed.charAt(firstMismatch)
                            + "')");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take the original passage
        System.out.print("Enter the original passage: ");
        String original = sc.nextLine();

        // Take the user's typed passage
        System.out.print("Enter your typed text: ");
        String typed = sc.nextLine();

        // Both strings must have the same length
        if (original.length() != typed.length()) {

            System.out.println(
                    "Error: Both strings must have the same length.");

        } else {

            // Create object to call the non-static method
            TypingSpeedTestAccuracyChecker obj =
                    new TypingSpeedTestAccuracyChecker();

            obj.checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}