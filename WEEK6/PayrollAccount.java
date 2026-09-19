import java.util.Scanner;

public class PayrollAccount {

    // Private fields for encapsulation
    private double basicSalary;
    private double bonus;

    // Constructor
    public PayrollAccount(double basicSalary) {

        // Negative salary is not allowed
        if (basicSalary < 0) {

            System.out.println(
                    "Warning: Negative salary entered. "
                            + "Basic salary set to Rs 0.0"
            );

            this.basicSalary = 0;

        } else {

            this.basicSalary = basicSalary;
        }

        // Bonus starts from zero
        this.bonus = 0;
    }

    // Add a valid bonus
    public void creditBonus(double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Invalid bonus: Amount must be greater than 0."
            );

        } else {

            bonus += amount;

            System.out.println(
                    "Bonus credited: Rs " + amount
            );
        }
    }

    // Deduct tax from basic salary
    public void deductTax(double percent) {

        if (percent < 0 || percent > 100) {

            System.out.println(
                    "Invalid tax percentage. "
                            + "Enter a value between 0 and 100."
            );

        } else {

            basicSalary =
                    basicSalary - (basicSalary * percent / 100);

            System.out.println(
                    "Tax deducted: " + percent + "%"
            );
        }
    }

    // Read-only access to net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter basic salary: Rs ");
        double salary = sc.nextDouble();

        PayrollAccount account =
                new PayrollAccount(salary);

        System.out.print("Enter bonus amount: Rs ");
        double bonus = sc.nextDouble();

        account.creditBonus(bonus);

        System.out.print("Enter tax percentage: ");
        double tax = sc.nextDouble();

        account.deductTax(tax);

        System.out.println(
                "Net salary: Rs "
                        + account.getNetSalary()
        );

        sc.close();
    }
}