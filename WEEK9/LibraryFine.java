import java.util.Scanner;

abstract class LibraryItem {

    protected String title;
    protected int daysLate;

    public LibraryItem(
        String title,
        int daysLate
    ) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();

    public String getTitle() {
        return title;
    }
}


class Book extends LibraryItem {

    public Book(
        String title,
        int daysLate
    ) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2;
    }
}


class DVD extends LibraryItem {

    public DVD(
        String title,
        int daysLate
    ) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {

        double fine = daysLate * 5;

        if (fine > 50) {
            fine = 50;
        }

        return fine;
    }
}


class Magazine extends LibraryItem {

    public Magazine(
        String title,
        int daysLate
    ) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate;
    }
}


public class LibraryFine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LibraryItem[] items =
            new LibraryItem[n];

        for (int i = 0; i < n; i++) {

            String type =
                sc.next().toUpperCase();

            String title = sc.next();

            int daysLate =
                sc.nextInt();

            if (type.equals("BOOK")) {

                items[i] =
                    new Book(
                        title,
                        daysLate
                    );

            } else if (type.equals("DVD")) {

                items[i] =
                    new DVD(
                        title,
                        daysLate
                    );

            } else if (type.equals("MAGAZINE")) {

                items[i] =
                    new Magazine(
                        title,
                        daysLate
                    );
            }
        }

        double total = 0;

        for (LibraryItem item : items) {

            double fine =
                item.calculateFine();

            System.out.printf(
                "%s: %.2f%n",
                item.getTitle(),
                fine
            );

            total += fine;
        }

        System.out.printf(
            "Total Fines: %.2f%n",
            total
        );

        sc.close();
    }
}