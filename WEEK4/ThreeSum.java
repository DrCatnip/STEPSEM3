import java.util.*
public class ThreeSum {
    public int[][] threeSum(int[] nums) {
        // Sort the array first
        Arrays.sort(nums);
        // Store all valid triplets
        ArrayList<int[]> result = new ArrayList<>();
        // Fix the first number
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate first values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Two pointers
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // Store the valid triplet
                    result.add(new int[]{nums[i],nums[left],nums[right]});
                    // Move both pointers
                    left++;
                    right--;

                    // Skip duplicate left values
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    // Need a larger sum
                    left++;
                } else {
                    // Need a smaller sum
                    right--;
                }
            }
        }

        // Convert ArrayList<int[]> to int[][]
        int[][] answer = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
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

        ThreeSum obj = new ThreeSum();
        int[][] result = obj.threeSum(nums);
        System.out.println("Unique triplets with sum 0:");
        if (result.length == 0) {
            System.out.println("No valid triplets found.");
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.println(Arrays.toString(result[i]));
            }
        }

        sc.close();
    }
}