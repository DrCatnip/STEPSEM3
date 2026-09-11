import java.util.Scanner;

public class MatchDayGridAnalyzer {

    // Calculate the average of one match
    private static double rowAverage(int[] row) {

        int sum = 0;

        // Add all runs scored in the match
        for (int runs : row) {
            sum += runs;
        }

        // Return average runs per over
        return (double) sum / row.length;
    }

    // Classify every match based on the threshold
    static String classifyMatches(int[][] runsPerOver,int threshold) {
        StringBuilder result = new StringBuilder();

        // Process each match
        for (int i = 0; i < runsPerOver.length; i++) {

            // Calculate this match's average
            double average = rowAverage(runsPerOver[i]);

            // Decide whether it is Power Surge or Normal
            if (average >= threshold) {

                result.append("Match " + i + ": Power Surge");

            } else {

                result.append("Match " + i + ": Normal");
            }

            // Add separator between matches
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int matches = sc.nextInt();

        int[][] runsPerOver = new int[matches][];

        // Take input for every match
        for (int i = 0; i < matches; i++) {

            System.out.print("Enter number of overs for Match " + i + ": ");
            int overs = sc.nextInt();

            runsPerOver[i] = new int[overs];

            System.out.println("Enter runs for Match " + i + ":");

            for (int j = 0; j < overs; j++) {

                System.out.print("Over " + j + ": ");

                runsPerOver[i][j] = sc.nextInt();
            }
        }

        System.out.print("\nEnter Power Surge threshold: ");
        int threshold = sc.nextInt();
        String result = classifyMatches(runsPerOver,threshold);
        System.out.println("\nMatch Classification:");
        System.out.println(result);

        sc.close();
    }
}