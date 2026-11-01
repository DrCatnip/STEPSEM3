import java.util.Scanner;

// Class problem 9: input is one year.
public class LeapYearDetector {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        System.out.println(leap ? "Leap year" : "Not a leap year");
        sc.close();
    }
}
