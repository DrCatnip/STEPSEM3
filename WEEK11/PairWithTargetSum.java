import java.util.Scanner;
import java.util.HashSet;

// Class problem 5: n, n integers, then target.
public class PairWithTargetSum {
    // Expected O(n) time, O(n) space using a set.
    // Brute force: O(n^2) time, O(1) extra space; check every pair of indices.
    // Sorting and two pointers: O(n log n) time, with space depending on the sort.
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Long> seen = new HashSet<>();
        for (int number : nums) {
            // Widen before subtraction so extreme integer values cannot overflow.
            long complement = (long) target - number;
            if (seen.contains(complement)) {
                return true;
            }
            // Insert after checking: an element cannot pair with itself.
            seen.add((long) number);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(hasPairWithSum(nums, target));
        sc.close();
    }
}
