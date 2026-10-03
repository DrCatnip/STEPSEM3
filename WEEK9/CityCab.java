import java.util.Scanner;

interface NightService {
    double calculateNightFare(double fare);
}

abstract class Cab {
    protected double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    abstract String getType();

    double calculateFare() {
        double fare = calculateBaseFare();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

class MiniCab extends Cab {

    MiniCab(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 10;
    }

    String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {

    SedanCab(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 14;
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightService {

    SUVCab(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 18;
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SUV";
    }
}

public class CityCab {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;

            if (type.equalsIgnoreCase("MINI")) {
                cab = new MiniCab(distance);
            }
            else if (type.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab(distance);
            }
            else if (type.equalsIgnoreCase("SUV")) {
                cab = new SUVCab(distance);
            }

            double fare = cab.calculateFare();

            if (time.equalsIgnoreCase("NIGHT")) {

                if (cab instanceof NightService) {

                    NightService nightCab =
                        (NightService) cab;

                    fare = nightCab.calculateNightFare(fare);

                    System.out.printf(
                        "%s: %.2f%n",
                        cab.getType(),
                        fare
                    );

                }
                else {
                    System.out.printf(
                        "%s: NIGHT SERVICE UNAVAILABLE%n",
                        cab.getType()
                    );
                }

            }
            else {

                System.out.printf(
                    "%s: %.2f%n",
                    cab.getType(),
                    fare
                );
            }
        }

        sc.close();
    }
}