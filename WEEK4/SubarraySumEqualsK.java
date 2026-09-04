import java.util.HashMap;
import java.util.Scanner;
public class SubarraySumEqualsK {
    // Method to count subarrays whose sum equals k
    public int subarraySum(int[] nums, int k) {
        // Stores prefix sum and its frequency
        HashMap<Integer, Integer> prefixFrequency = new HashMap<>();
        // Empty prefix has sum 0
        prefixFrequency.put(0, 1);
        int currentSum = 0;
        int count = 0;

        // Traverse the array
        for (int num : nums) {
            // Update running prefix sum
            currentSum += num;
            // Find the prefix sum needed
            int requiredSum = currentSum - k;
            // If it exists, those subarrays have sum k
            if (prefixFrequency.containsKey(requiredSum)) {
                count += prefixFrequency.get(requiredSum);
            }
            // Store/update current prefix sum frequency
            prefixFrequency.put(currentSum,prefixFrequency.getOrDefault(currentSum, 0) + 1);
        }
        return count;
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

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        int result = obj.subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result);
        sc.close();
    }
}