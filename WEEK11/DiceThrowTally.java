import java.util.Scanner;
import java.util.Arrays;

// Assignment 5: n followed by n die rolls, each from 1 to 6.
public class DiceThrowTally {
    // Counting sort: O(n + 6) time, O(6) counting space and O(n) output space.
    // No two throws are compared with each other.
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }
        System.out.print("Counts:");
        for (int value = 1; value <= 6; value++) {
            System.out.print(" " + value + ":" + count[value]);
        }
        System.out.println();
        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int value = 1; value <= 6; value++) {
            for (int i = 0; i < count[value]; i++) {
                sorted[index++] = value;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rolls = new int[n];
        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
        }
        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));
        sc.close();
    }
}
