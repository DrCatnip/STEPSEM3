import java.util.Scanner;

// Assignment 4: n followed by n tokens. An empty queue is permitted.
public class QueueOrderCheck {
    // O(n) time and O(1) extra space. Equal neighboring tokens are allowed.
    public static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tokens = new int[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextInt();
        }
        System.out.println(firstBreak(tokens));
        sc.close();
    }
}
