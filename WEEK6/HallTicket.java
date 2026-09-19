import java.util.Scanner;

public class HallTicket {

    String studentName;
    int seatNumber;

    // Constructor
    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter initial seat number: ");
        int initialSeat = sc.nextInt();

        // Create the original object
        HallTicket priya =
                new HallTicket(
                        studentName,
                        initialSeat
                );

        // Second variable points to the SAME object
        HallTicket copy = priya;

        System.out.print(
                "Enter new seat number through second reference: "
        );

        int newSeat = sc.nextInt();

        // Modify through the second reference
        copy.seatNumber = newSeat;

        // Create a completely separate object
        HallTicket separate =
                new HallTicket(
                        studentName,
                        newSeat
                );

        System.out.println(
                "\nStudent's seatNumber through first variable:"
        );

        System.out.println(priya.seatNumber);

        // Check whether both references point
        // to the same object
        System.out.println(
                "copy == priya: "
                        + (copy == priya)
        );

        // Check whether separate object is the same
        // object as priya
        System.out.println(
                "separate == priya: "
                        + (separate == priya)
        );

        sc.close();
    }
}