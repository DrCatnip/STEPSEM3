import java.util.Scanner;

abstract class Connection {

    protected double units;

    public Connection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}


class HomeConnection extends Connection {

    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {

        if (units <= 100) {
            return units * 5;
        }

        return (100 * 5)
             + ((units - 100) * 7);
    }

    @Override
    public String getType() {
        return "HOME";
    }
}


class ShopConnection extends Connection {

    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8) + 100;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}


class FactoryConnection extends Connection {

    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {

        double bill = units * 6;

        if (bill < 1000) {
            bill = 1000;
        }

        return bill;
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}


public class ElectricityBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Connection[] connections =
            new Connection[n];

        for (int i = 0; i < n; i++) {

            String type =
                sc.next().toUpperCase();

            double units =
                sc.nextDouble();

            if (type.equals("HOME")) {

                connections[i] =
                    new HomeConnection(units);

            } else if (type.equals("SHOP")) {

                connections[i] =
                    new ShopConnection(units);

            } else if (type.equals("FACTORY")) {

                connections[i] =
                    new FactoryConnection(units);
            }
        }

        double total = 0;

        for (Connection connection : connections) {

            double bill =
                connection.calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                connection.getType(),
                bill
            );

            total += bill;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}