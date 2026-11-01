import java.util.Scanner;

// Assignment 5 (source problem 7): n followed by n scores from 0 to 100.
public class SecondBestScore {
    // O(n) time and O(1) extra space; sorting first would take O(n log n) time.
    public static int secondHighest(int[] scores) {
        // Valid scores are non-negative, so -1 safely represents a missing score.
        int highest = -1;
        int second = -1;
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        System.out.println(secondHighest(scores));
        sc.close();
    }
}
