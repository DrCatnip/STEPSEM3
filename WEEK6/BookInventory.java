import java.util.Scanner;

public class BookInventory {

    // Instance fields
    String title;
    String author;
    int copiesAvailable;

    // Constructor
    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Method to print one book's details
    void printEntry() {
        System.out.println(
                title + " by " + author
                        + " - " + copiesAvailable
                        + " copies available"
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // The assignment requires four BookInventory objects
        BookInventory[] books = new BookInventory[4];

        System.out.println("Enter details for 4 books:\n");

        // Create four objects using user input
        for (int i = 0; i < books.length; i++) {

            System.out.println("Book " + (i + 1));

            System.out.print("Enter book title: ");
            String title = sc.nextLine();

            System.out.print("Enter author name: ");
            String author = sc.nextLine();

            System.out.print("Enter number of copies available: ");
            int copies = sc.nextInt();

            sc.nextLine();

            // Create the BookInventory object
            books[i] = new BookInventory(
                    title,
                    author,
                    copies
            );

            System.out.println();
        }

        System.out.println("Library Inventory:");
        System.out.println("------------------");

        // Print every book using the instance method
        for (BookInventory book : books) {
            book.printEntry();
        }

        sc.close();
    }
}