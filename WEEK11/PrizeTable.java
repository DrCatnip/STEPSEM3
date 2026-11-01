import java.util.Scanner;
import java.util.Arrays;

// Assignment 2: n followed by n marks.
public class PrizeTable {
    // Descending selection sort: O(n^2) time, O(1) extra space.
    public static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maximum = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maximum]) {
                    maximum = j;
                }
            }
            // Do not count a round when the maximum is already in position.
            if (maximum != i) {
                int temp = marks[i];
                marks[i] = marks[maximum];
                marks[maximum] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }
        int swaps = prizeTable(marks);
        System.out.println(Arrays.toString(marks));
        System.out.println("swaps = " + swaps);
        sc.close();
    }
}
