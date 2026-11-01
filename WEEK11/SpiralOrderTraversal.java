import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Class problem 8: rows columns, then the rectangular grid values row by row.
public class SpiralOrderTraversal {
    // O(m * n) time, O(m * n) output space, and O(1) other extra space.
    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid.length == 0 || grid[0].length == 0) {
            return result;
        }
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; column++) {
                result.add(grid[top][column]);
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                result.add(grid[row][right]);
            }
            right--;
            // These checks prevent repeating a lone remaining row or column.
            if (top <= bottom) {
                for (int column = right; column >= left; column--) {
                    result.add(grid[bottom][column]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(grid[row][left]);
                }
                left++;
            }
        }
        return result;
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
        System.out.println(spiralOrder(grid));
        sc.close();
    }
}
