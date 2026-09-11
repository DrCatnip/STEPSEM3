import java.util.Scanner;

public class DuplicatePlayerPickChecker {

    // Method to find the first duplicate player
    static String findDuplicatePick(String[] playerNames) {

        // Outer loop selects the current player
        for (int i = 0; i < playerNames.length; i++) {

            // Inner loop compares with players after it
            for (int j = i + 1;
                 j < playerNames.length;
                 j++) {

                // Compare the two player names
                if (playerNames[i].equals(playerNames[j])) {

                    // Return immediately when first duplicate is found
                    return "Duplicate Found: "
                            + playerNames[i];
                }
            }
        }

        // No duplicate was found
        return "No Duplicates Found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        sc.nextLine();

        String[] playerNames = new String[n];

        System.out.println("Enter player names:");

        for (int i = 0; i < n; i++) {

            System.out.print("Player " + i + ": ");
            playerNames[i] = sc.nextLine();
        }

        String result = findDuplicatePick(playerNames);

        System.out.println("\nResult: " + result);

        sc.close();
    }
}