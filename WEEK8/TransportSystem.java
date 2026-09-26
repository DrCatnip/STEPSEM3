import java.util.Scanner;

interface Transport {
    double calculateFare();
    String getType();
}

class Bus implements Transport {

    private double distance;

    public Bus(double distance) {
        this.distance = distance;
    }

    @Override
    public double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    @Override
    public String getType() {
        return "BUS";
    }
}

class Train implements Transport {

    private double distance;

    public Train(double distance) {
        this.distance = distance;
    }

    @Override
    public double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }
}

class Metro implements Transport {

    private double distance;
    private double peakHourFactor;

    public Metro(
        double distance,
        double peakHourFactor
    ) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {

        double baseFare =
            1.50 + (0.20 * distance);

        return baseFare * peakHourFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }
}

public class TransportSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Transport[] transports = new Transport[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double distance = sc.nextDouble();

            if (type.equals("BUS")) {

                transports[i] =
                    new Bus(distance);

            } else if (type.equals("TRAIN")) {

                transports[i] =
                    new Train(distance);

            } else if (type.equals("METRO")) {

                double peakHourFactor =
                    sc.nextDouble();

                transports[i] =
                    new Metro(
                        distance,
                        peakHourFactor
                    );
            }
        }

        double total = 0;

        for (Transport transport : transports) {

            double fare =
                transport.calculateFare();

            System.out.printf(
                "%s: %.2f%n",
                transport.getType(),
                fare
            );

            total += fare;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}