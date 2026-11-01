import java.util.Scanner;

// Assignment 4 (source problem 4): n, n ascending scores, then low high.
public class ExamScoreBandCounter {
    // A linear scan takes O(n) time and O(1) space per query.
    // Two binary searches take O(log n) time and O(1) space per query.
    public static int countInBand(int[] scores, int low, int high) {
        return boundary(scores, high, true) - boundary(scores, low, false);
    }

    // Find first score > target (strict) or >= target (non-strict).
    // Searching for boundaries includes every duplicate at either edge.
    private static int boundary(int[] scores, int target, boolean strict) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] < target || (strict && scores[mid] == target)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(countInBand(scores, low, high));
        sc.close();
    }
}
