import java.util.Scanner;

// Class problem 2: rows columns, then the non-negative grid values row by row.
public class WarehouseBinGridScan {
    // O(m * n) time and O(1) extra space. Result: total, row, column.
    // For an empty grid, (-1, -1) indicates that no maximum bin exists.
    public static long[] warehouseSummary(int[][] grid) {
        long total = 0;
        int maximum = -1;
        int bestRow = -1;
        int bestColumn = -1;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                int items = grid[row][column];
                total += items;
                // Keep the first bin when maxima tie in row-major order.
                if (items > maximum) {
                    maximum = items;
                    bestRow = row;
                    bestColumn = column;
                }
            }
        }
        return new long[] {total, bestRow, bestColumn};
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
        long[] result = warehouseSummary(grid);
        System.out.printf("total = %d, maxCoordinate = (%d, %d)%n",
            result[0], result[1], result[2]);
        sc.close();
    }
}
