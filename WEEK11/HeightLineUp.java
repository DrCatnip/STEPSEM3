import java.util.Scanner;
import java.util.Arrays;

// Assignment 1: n followed by n heights. At most n - 1 sweeps, as in the sample.
public class HeightLineUp {
    // Bubble sort: O(n^2) worst-case time, O(n) best case, O(1) sorting space.
    public static void lineUp(int[] heights) {
        for (int pass = 1; pass < heights.length; pass++) {
            boolean swapped = false;
            for (int j = 0; j < heights.length - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            // Print even the final sweep that makes no swaps.
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        lineUp(heights);
        sc.close();
    }
}
