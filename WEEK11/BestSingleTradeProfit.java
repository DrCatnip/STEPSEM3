import java.util.Scanner;

// Class problem 6: n followed by n non-negative prices in chronological order.
public class BestSingleTradeProfit {
    // One pass: O(n) time, O(1) space; checking all day pairs costs O(n^2).
    // Tracking the cheapest earlier price avoids repeated work at scale.
    public static int maxProfit(int[] prices) {
        int minimum = Integer.MAX_VALUE;
        int best = 0;
        for (int price : prices) {
            if (price < minimum) {
                minimum = price;
            } else {
                best = Math.max(best, price - minimum);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        System.out.println(maxProfit(prices));
        sc.close();
    }
}
