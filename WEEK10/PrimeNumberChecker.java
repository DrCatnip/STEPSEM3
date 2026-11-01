import java.util.Scanner;

// Class problem 6: input is one integer.
public class PrimeNumberChecker {
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        // Division avoids overflow from divisor * divisor for large integers.
        for (int divisor = 2; divisor <= number / divisor; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(number + (isPrime(number) ? " is prime" : " is not prime"));
        sc.close();
    }
}
