import java.util.Scanner;

public class EmployeeProfile {

    // Employee class
    static class Employee {

        String empId;
        String empName;
        double salary;
        boolean isIntern;

        // Constructor for permanent employees
        public Employee(
                String empId,
                String empName,
                double salary) {

            this.empId = empId;
            this.empName = empName;
            this.salary = salary;

            // Permanent employee
            this.isIntern = false;
        }

        // Constructor for interns
        public Employee(
                String empId,
                String empName) {

            // Chain to the three-argument constructor
            this(empId, empName, 0);

            // Change intern status after constructor chaining
            this.isIntern = true;
        }

        // Print employee information
        public void printProfile() {

            System.out.println(
                    empId + " | "
                            + empName + " | Rs "
                            + salary + " | Intern: "
                            + isIntern
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Permanent employee
        System.out.println("Permanent Employee");

        System.out.print("Enter employee ID: ");
        String permanentId = sc.nextLine();

        System.out.print("Enter employee name: ");
        String permanentName = sc.nextLine();

        System.out.print("Enter salary: Rs ");
        double permanentSalary = sc.nextDouble();

        sc.nextLine();

        Employee permanentEmployee =
                new Employee(
                        permanentId,
                        permanentName,
                        permanentSalary
                );

        // Intern
        System.out.println("\nIntern Employee");

        System.out.print("Enter employee ID: ");
        String internId = sc.nextLine();

        System.out.print("Enter employee name: ");
        String internName = sc.nextLine();

        Employee internEmployee =
                new Employee(
                        internId,
                        internName
                );

        System.out.println("\nEmployee Profiles:");
        System.out.println("------------------");

        permanentEmployee.printProfile();
        internEmployee.printProfile();

        sc.close();
    }
}