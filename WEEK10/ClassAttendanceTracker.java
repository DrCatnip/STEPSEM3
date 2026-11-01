import java.util.Scanner;

// Assignment 2 (source problem 6): n followed by n attendance values (0 or 1).
public class ClassAttendanceTracker {
    // Both answers use one pass: O(n) time and O(1) extra space.
    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longest = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;
                longest = Math.max(longest, streak);
            } else {
                streak = 0;
            }
        }
        return new int[] {present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
        sc.close();
    }
}
