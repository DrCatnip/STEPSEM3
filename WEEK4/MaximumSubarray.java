import java.util.Scanner;
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // Start with the first element
        int currentSum = nums[0];
        // Store the best sum found so far
        int maxSum = nums[0];
        // Start checking from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current subarray
            // or start a new subarray from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        MaximumSubarray obj = new MaximumSubarray();
        int result = obj.maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + result);
        sc.close();
    }
}