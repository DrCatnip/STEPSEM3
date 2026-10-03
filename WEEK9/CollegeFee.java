import java.util.Scanner;

interface BusUser {
    double getBusFee();
}

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    abstract String getType();
}

class DayScholar extends Student implements BusUser {

    DayScholar(String name) {
        super(name);
    }

    public double getBusFee() {
        return 12000;
    }

    double calculateFee() {
        return 40000 + getBusFee();
    }

    String getType() {
        return "DAY_SCHOLAR";
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }

    String getType() {
        return "HOSTELLER";
    }
}

class Scholar extends Student implements BusUser {

    Scholar(String name) {
        super(name);
    }

    public double getBusFee() {
        return 12000;
    }

    double calculateFee() {
        return 20000 + getBusFee();
    }

    String getType() {
        return "SCHOLAR";
    }
}

public class CollegeFee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            }
            else if (type.equalsIgnoreCase("HOSTELLER")) {
                students[i] = new Hosteller(name);
            }
            else if (type.equalsIgnoreCase("SCHOLAR")) {
                students[i] = new Scholar(name);
            }
        }

        double total = 0;

        for (Student student : students) {

            System.out.printf(
                "%s (%s): %.2f%n",
                student.name,
                student.getType(),
                student.calculateFee()
            );

            total += student.calculateFee();
        }

        System.out.printf("Total Fees: %.2f%n", total);

        sc.close();
    }
}