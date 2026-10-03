import java.util.Scanner;

abstract class Ticket {
    protected String customerName;
    protected int tickets;

    Ticket(String customerName, int tickets) {
        this.customerName = customerName;
        this.tickets = tickets;
    }

    abstract double calculateTicketPrice();

    double calculateTotal() {
        return calculateTicketPrice() + (tickets * 20);
    }

    abstract String getType();
}

class RegularTicket extends Ticket {

    RegularTicket(String customerName, int tickets) {
        super(customerName, tickets);
    }

    double calculateTicketPrice() {
        return tickets * 150;
    }

    String getType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {

    PremiumTicket(String customerName, int tickets) {
        super(customerName, tickets);
    }

    double calculateTicketPrice() {
        return tickets * 250;
    }

    String getType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {

    ReclinerTicket(String customerName, int tickets) {
        super(customerName, tickets);
    }

    double calculateTicketPrice() {
        return tickets * 400;
    }

    String getType() {
        return "RECLINER";
    }
}

public class MovieTicket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            int count = sc.nextInt();

            if (type.equalsIgnoreCase("REGULAR")) {
                tickets[i] = new RegularTicket(name, count);
            }
            else if (type.equalsIgnoreCase("PREMIUM")) {
                tickets[i] = new PremiumTicket(name, count);
            }
            else if (type.equalsIgnoreCase("RECLINER")) {
                tickets[i] = new ReclinerTicket(name, count);
            }
        }

        double total = 0;

        for (Ticket ticket : tickets) {

            System.out.printf(
                "%s (%s): %.2f%n",
                ticket.customerName,
                ticket.getType(),
                ticket.calculateTotal()
            );

            total += ticket.calculateTotal();
        }

        System.out.printf("Total Revenue: %.2f%n", total);

        sc.close();
    }
}