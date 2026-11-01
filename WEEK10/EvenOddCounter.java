import java.util.Scanner;

// Class problem 3: input is n followed by n integers.
public class EvenOddCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int even = 0;
        int odd = 0;
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
