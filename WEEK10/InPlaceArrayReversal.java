import java.util.Scanner;
import java.util.Arrays;

// Class problem 4: input is n followed by n integers.
public class InPlaceArrayReversal {
    // Two pointers reverse the original array in O(n) time and O(1) extra space.
    public static void reverse(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        reverse(numbers);
        System.out.println(Arrays.toString(numbers));
        sc.close();
    }
}
