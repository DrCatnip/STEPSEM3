import java.util.Scanner;

interface ShippingCharge {
    double calculateShippingCharge(double weight);
}

interface Insurance {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected String name;
    protected double weight;
    protected double declaredValue;

    Parcel(String name, double weight, double declaredValue) {
        this.name = name;
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract String getType();
}

class StandardParcel extends Parcel implements ShippingCharge, Insurance {

    StandardParcel(String name, double weight, double declaredValue) {
        super(name, weight, declaredValue);
    }

    public double calculateShippingCharge(double weight) {
        return 40 + (10 * weight);
    }

    public double calculateInsurance(double declaredValue) {
        return 0;
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements ShippingCharge, Insurance {

    ExpressParcel(String name, double weight, double declaredValue) {
        super(name, weight, declaredValue);
    }

    public double calculateShippingCharge(double weight) {
        return 80 + (15 * weight);
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }

    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements ShippingCharge, Insurance {

    FragileParcel(String name, double weight, double declaredValue) {
        super(name, weight, declaredValue);
    }

    public double calculateShippingCharge(double weight) {
        return 40 + (10 * weight) + 50;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShipping {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            if (type.equalsIgnoreCase("STANDARD")) {
                parcels[i] =
                    new StandardParcel(name, weight, declaredValue);
            }
            else if (type.equalsIgnoreCase("EXPRESS")) {
                parcels[i] =
                    new ExpressParcel(name, weight, declaredValue);
            }
            else if (type.equalsIgnoreCase("FRAGILE")) {
                parcels[i] =
                    new FragileParcel(name, weight, declaredValue);
            }
        }

        double total = 0;

        for (Parcel parcel : parcels) {

            ShippingCharge shipping =
                (ShippingCharge) parcel;

            Insurance insurance =
                (Insurance) parcel;

            double shippingCharge =
                shipping.calculateShippingCharge(parcel.weight);

            double insuranceCharge =
                insurance.calculateInsurance(parcel.declaredValue);

            double parcelTotal =
                shippingCharge + insuranceCharge;

            System.out.printf(
                "%s (%s): Charge %.2f, Insurance %.2f, Total %.2f%n",
                parcel.name,
                parcel.getType(),
                shippingCharge,
                insuranceCharge,
                parcelTotal
            );

            total += parcelTotal;
        }

        System.out.printf("Total Shipping Cost: %.2f%n", total);

        sc.close();
    }
}