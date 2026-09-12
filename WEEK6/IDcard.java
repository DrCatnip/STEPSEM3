public class IDcard {

    String name;
    int booksIssued;

    IDcard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        IDcard ravi = new IDcard("Ravi", 0);

        IDcard duplicate = ravi;

        duplicate.booksIssued = 3;

        IDcard separate = new IDcard("Ravi", 3);

        System.out.println(
            "Ravi's booksIssued (via first variable): "
            + ravi.booksIssued
        );

        System.out.println(
            "duplicate == ravi: " + (duplicate == ravi)
        );

        System.out.println(
            "separate == ravi: " + (separate == ravi)
        );
    }
}