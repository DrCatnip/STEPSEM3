import java.util.Scanner;

public class TopPerformerTracker {

    // Find minimum, maximum and spread
    // in a single pass
    static String findMinMaxSpread(int[] scores) {

        // Assume the first score is both minimum and maximum
        int min = scores[0];
        int max = scores[0];

        // Check the remaining scores
        for (int i = 1; i < scores.length; i++) {

            // Update minimum if a smaller value is found
            if (scores[i] < min) {
                min = scores[i];
            }

            // Update maximum if a larger value is found
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        // Calculate the difference between maximum and minimum
        int spread = max - min;

        return "Min: " + min
                + " | Max: " + max
                + " | Spread: " + spread;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter the scores:");

        for (int i = 0; i < n; i++) {

            System.out.print("Score " + i + ": ");
            scores[i] = sc.nextInt();
        }

        String result = findMinMaxSpread(scores);

        System.out.println("\nWeekly Performance:");
        System.out.println(result);

        sc.close();
    }
}