import java.util.Scanner;

interface Payment {
    double calculateAmount();
    String getType();
}

class CardPayment implements Payment {

    private double amount;

    public CardPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateAmount() {
        return amount + (amount * 0.02);
    }

    @Override
    public String getType() {
        return "CARD";
    }
}

class WalletPayment implements Payment {

    private double amount;

    public WalletPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateAmount() {
        return amount + (amount * 0.01);
    }

    @Override
    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment implements Payment {

    private double amount;

    public BankTransferPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } else if (type.equals("BANKTRANSFER")) {
                payments[i] = new BankTransferPayment(amount);
            }
        }

        double total = 0;

        for (Payment payment : payments) {

            double adjustedAmount = payment.calculateAmount();

            System.out.printf(
                "%s: %.2f%n",
                payment.getType(),
                adjustedAmount
            );

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}