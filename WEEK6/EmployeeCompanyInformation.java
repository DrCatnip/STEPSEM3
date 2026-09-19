import java.util.Scanner;

public class EmployeeCompanyInformation {

    static class Employee {

        // Instance fields
        String empName;
        double salary;

        // Static field shared by every employee
        static String companyName =
                "Bright Horizon Technologies";

        // Static counter shared by every employee
        static int employeeCount = 0;

        // Constructor
        Employee(String empName, double salary) {

            this.empName = empName;
            this.salary = salary;

            // Increase employee count whenever
            // a new Employee object is created
            employeeCount++;
        }

        // Static method
        static void printCompanyInfo() {

            System.out.println(companyName);
            System.out.println(
                    "Employees on record: "
                            + employeeCount
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Enter details for 3 employees:\n"
        );

        for (int i = 0; i < 3; i++) {

            System.out.println(
                    "Employee " + (i + 1)
            );

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter salary: Rs ");
            double salary = sc.nextDouble();

            sc.nextLine();

            // Create Employee object
            new Employee(name, salary);

            System.out.println();
        }

        System.out.println("Company Information:");
        System.out.println("--------------------");

        // Call static method through the CLASS NAME
        Employee.printCompanyInfo();

        sc.close();
    }
}