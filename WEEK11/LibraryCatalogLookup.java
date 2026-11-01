import java.util.Scanner;

// Class problem 1: n, then n lines containing ISBN and title; then q and q ISBNs.
// ISBNs are strings (preserving leading zeros), supplied in ascending string order.
class Book {
    String isbn;
    String title;

    Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}

public class LibraryCatalogLookup {
    // O(log n) time per query, O(1) extra space. No repeated catalog scans.
    // An already sorted catalog suits frequent queries and rare updates.
    public static String findBook(Book[] catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = catalog[mid].isbn.compareTo(targetIsbn);
            if (comparison == 0) {
                return catalog[mid].title;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Book[] catalog = new Book[n];
        for (int i = 0; i < n; i++) {
            String isbn = sc.next();
            String title = sc.nextLine().trim();
            catalog[i] = new Book(isbn, title);
        }
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            System.out.println(findBook(catalog, sc.next()));
        }
        sc.close();
    }
}
