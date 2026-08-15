import java.util.*;

public class ExamHallSeatDuplicationChecker {
    // method to check for duplicate seat numbers in the exam hall
    public void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate seat number found: " + seatNumbers[i]);
                    duplicateFound = true;
                }
            }
        }
        if (!duplicateFound) {
            System.out.println("No duplicate seat numbers found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        int[] seatNumbers = new int[n];
        System.out.println("enter the seat numbers of the students: ");
        for (int i = 0; i < n; i++) {
            System.out.println("seat number of the student " + (i + 1) + ": ");
            seatNumbers[i] = sc.nextInt();
        }

        ExamHallSeatDuplicationChecker obj = new ExamHallSeatDuplicationChecker();
        System.out.println("Checking for seat allocation.....");
        obj.checkDuplicateSeats(seatNumbers);
      
    }

}
