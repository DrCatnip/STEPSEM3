import java.util.Scanner;
public class ProductOfArrayExceptSelf {
  
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        // Running product of elements to the left
        int leftProduct = 1;
        // First pass: store product of all elements to the left
        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        // Running product of elements to the right
        int rightProduct = 1;
        // Second pass: multiply by product of all elements to the right
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
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
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] answer = obj.productExceptSelf(nums);
        System.out.print("Product except self: [");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
            if (i < answer.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        sc.close();
    }
}