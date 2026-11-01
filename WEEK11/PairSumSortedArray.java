import java.util.Scanner;

// Class problem 9: n, n ascending integers, then target.
public class PairSumSortedArray {
    // O(n) time and O(1) extra space, compared with O(n^2) brute-force pair checks.
    // Return null when no pair of distinct indices exists.
    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            long sum = (long) nums[left] + nums[right];
            if (sum == target) {
                return new int[] {nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] pair = pairSumSorted(nums, target);
        if (pair == null) {
            System.out.println("Not Found");
        } else {
            System.out.printf("(%d, %d)%n", pair[0], pair[1]);
        }
        sc.close();
    }
}
