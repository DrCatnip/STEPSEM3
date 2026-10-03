import java.util.Scanner;

abstract class Staff {

    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}


class FullTimeStaff extends Staff {

    private double weeklySalary;

    public FullTimeStaff(
        String name,
        double weeklySalary
    ) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}


class HourlyStaff extends Staff {

    private double hours;
    private double rate;

    public HourlyStaff(
        String name,
        double hours,
        double rate
    ) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {

        if (hours <= 40) {
            return hours * rate;
        }

        double normalPay = 40 * rate;

        double overtimeHours = hours - 40;

        double overtimePay =
            overtimeHours * rate * 1.5;

        return normalPay + overtimePay;
    }
}


class Intern extends Staff {

    private double stipend;

    public Intern(
        String name,
        double stipend
    ) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}


public class WeeklyStaff {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {

            String type =
                sc.next().toUpperCase();

            String name = sc.next();

            if (type.equals("FULLTIME")) {

                double salary = sc.nextDouble();

                staff[i] =
                    new FullTimeStaff(
                        name,
                        salary
                    );

            } else if (type.equals("HOURLY")) {

                double hours = sc.nextDouble();
                double rate = sc.nextDouble();

                staff[i] =
                    new HourlyStaff(
                        name,
                        hours,
                        rate
                    );

            } else if (type.equals("INTERN")) {

                double stipend = sc.nextDouble();

                staff[i] =
                    new Intern(
                        name,
                        stipend
                    );
            }
        }

        double total = 0;

        for (Staff person : staff) {

            double pay =
                person.calculatePay();

            System.out.printf(
                "%s: %.2f%n",
                person.getName(),
                pay
            );

            total += pay;
        }

        System.out.printf(
            "Total Payroll: %.2f%n",
            total
        );

        sc.close();
    }
}