import java.util.Scanner;
public class LibraryISBNNormalizerValidator {
    // Method to remove spaces and uppercase the first 3 characters
    public String normalizeCode(String raw) {
        String code = raw.trim();
        if (code.length() < 3) {
            return code;
        }

        // Get the first 3 characters and convert them to uppercase
        String publisherCode = code.substring(0, 3).toUpperCase();
        // Get everything after the first 3 characters
        String remainingPart = code.substring(3);
        return publisherCode + remainingPart;
    }

    // Method to validate and format the normalized code
    public String validateAndFormat(String code) {

        // Check length first
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: code body must contain only digits";
            }
        }

        // Extract publisher code
        String publisherCode = code.substring(0, 3);
        // Extract year
        String year = code.substring(3, 7);
        // Extract catalog number
        String catalog = code.substring(7, 13);
        // Build the formatted result
        StringBuilder result = new StringBuilder();
        result.append("[").append(publisherCode).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ISBN-style code: ");
        String rawCode = sc.nextLine();
        LibraryISBNNormalizerValidator obj =
                new LibraryISBNNormalizerValidator();
        
        String normalizedCode = obj.normalizeCode(rawCode);
        System.out.println("Normalized Code: " + normalizedCode);
        // Validate and format the normalized code
        String result = obj.validateAndFormat(normalizedCode);
        System.out.println(result);

        sc.close();
    }
}