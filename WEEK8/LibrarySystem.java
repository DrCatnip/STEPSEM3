import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {

    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract LocalDate getDueDate(LocalDate currentDate);

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {

    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {

    public DVD(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {

    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LibraryItem[] items = new LibraryItem[n];

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(" "));
            String title = line.substring(line.indexOf(" ") + 1);

            // Remove quotation marks
            title = title.replace("\"", "");

            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {

            LocalDate dueDate = item.getDueDate(currentDate);

            System.out.println(
                item.getTitle() + ": " + dueDate
            );
        }

        sc.close();
    }
}