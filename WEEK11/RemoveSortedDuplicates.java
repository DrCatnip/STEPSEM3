import java.util.Scanner;

// Class problem 10: n followed by n ascending integers (duplicates allowed).
public class RemoveSortedDuplicates {
    // O(n) time and O(1) extra space: overwrite the input without another array.
    // Only the first returned-count positions contain the resulting unique values.
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int unique = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[unique - 1]) {
                nums[unique] = nums[i];
                unique++;
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.print("nums[0.." + (length - 1) + "] = [");
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(nums[i]);
        }
        System.out.println("]");
        sc.close();
    }
}
