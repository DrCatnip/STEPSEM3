import java.util.Scanner;
import java.math.BigInteger;

// Class problem 7: input is one non-negative integer.
public class FactorialCalculation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger factorial = BigInteger.ONE;
        // BigInteger keeps factorials above 20! from overflowing a long.
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
        sc.close();
    }
}
