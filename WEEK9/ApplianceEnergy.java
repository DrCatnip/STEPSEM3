import java.util.Scanner;

interface EnergySaver {
    double applyEnergySaving(double units);
}

abstract class Appliance {
    protected String name;
    protected double power;

    Appliance(String name, double power) {
        this.name = name;
        this.power = power;
    }

    double calculateUnits(double hours) {
        return (power * hours) / 1000;
    }

    double calculateCost(double units) {
        return units * 8;
    }

    abstract String getType();
}

class Fridge extends Appliance {

    Fridge(String name) {
        super(name, 150);
    }

    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements EnergySaver {

    AC(String name) {
        super(name, 1500);
    }

    public double applyEnergySaving(double units) {
        return units * 0.75;
    }

    String getType() {
        return "AC";
    }
}

class TV extends Appliance {

    TV(String name) {
        super(name, 100);
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements EnergySaver {

    Washer(String name) {
        super(name, 500);
    }

    public double applyEnergySaving(double units) {
        return units * 0.75;
    }

    String getType() {
        return "WASHER";
    }
}

public class ApplianceEnergy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double hours = sc.nextDouble();
            String saver = sc.next();

            if (type.equalsIgnoreCase("FRIDGE")) {
                appliances[i] = new Fridge(name);
            }
            else if (type.equalsIgnoreCase("AC")) {
                appliances[i] = new AC(name);
            }
            else if (type.equalsIgnoreCase("TV")) {
                appliances[i] = new TV(name);
            }
            else if (type.equalsIgnoreCase("WASHER")) {
                appliances[i] = new Washer(name);
            }

            double units =
                appliances[i].calculateUnits(hours);

            if (saver.equalsIgnoreCase("YES")) {

                if (appliances[i] instanceof EnergySaver) {

                    EnergySaver energySaver =
                        (EnergySaver) appliances[i];

                    units =
                        energySaver.applyEnergySaving(units);

                }
                else {

                    System.out.printf(
                        "%s: ENERGY SAVER NOT SUPPORTED%n",
                        appliances[i].getType()
                    );

                    continue;
                }
            }

            double cost =
                appliances[i].calculateCost(units);

            System.out.printf(
                "%s (%s): %.2f units, %.2f%n",
                name,
                appliances[i].getType(),
                units,
                cost
            );

            totalCost += cost;
        }

        System.out.printf(
            "Total Cost: %.2f%n",
            totalCost
        );

        sc.close();
    }
}