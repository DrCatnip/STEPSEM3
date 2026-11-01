import java.util.Scanner;

// Assignment 1 (source problem 10): rows columns, then the grid row by row.
public class BusiestBusRow {
    // O(r * c) time and O(1) additional space, including the fixed-size result.
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;
        for (int row = 0; row < grid.length; row++) {
            int total = 0;
            for (int students : grid[row]) {
                total += students;
            }
            // Strict comparison preserves the smaller row index on a tie.
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = row;
            }
        }
        return new int[] {bestRow, bestTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
        sc.close();
    }
}
