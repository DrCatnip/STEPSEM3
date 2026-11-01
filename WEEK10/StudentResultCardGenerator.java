import java.util.Scanner;
import java.util.Locale;

// Class problem 10: input is n, then n records: name mark1 mark2 mark3.
class Student {
    private String name;
    private int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() {
        return name;
    }

    double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / (double) marks.length;
    }

    char getGrade() {
        double average = calculateAverage();
        // The source requires B for every average >= 75, including >= 90.
        // Chosen remaining bands: C for [60, 75), D for [40, 60), F below 40.
        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        }
        return 'F';
    }
}

public class StudentResultCardGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] marks = new int[3];
            for (int j = 0; j < marks.length; j++) {
                marks[j] = sc.nextInt();
            }
            Student student = new Student(name, marks);
            System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n",
                student.getName().toUpperCase(Locale.ROOT),
                student.calculateAverage(), student.getGrade());
        }
        sc.close();
    }
}
