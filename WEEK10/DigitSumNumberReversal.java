import java.util.Scanner;
import java.math.BigInteger;

// Class problem 5: input is one positive integer.
public class DigitSumNumberReversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger number = sc.nextBigInteger();
        BigInteger reversed = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
        // Repeated division extracts digits; BigInteger avoids an unspecified size limit.
        while (number.signum() > 0) {
            BigInteger digit = number.remainder(BigInteger.TEN);
            sum = sum.add(digit);
            reversed = reversed.multiply(BigInteger.TEN).add(digit);
            number = number.divide(BigInteger.TEN);
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
        sc.close();
    }
}
