import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRankingEngine {
    // Player class represents one fantasy player
    static class Player implements Comparable<Player> {

        // Encapsulated player data
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        // Constructor
        public Player(String name, int matchesPlayed, double battingAverage,boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Experience-only draftability rule
        static boolean isDraftable(int matchesPlayed) {

            // Established players need at least 10 matches
            return matchesPlayed >= 10;
        }

        // Combined matches-and-fitness rule
        static boolean isDraftable(int matchesPlayed, boolean injured) {

            // Newer players need at least 5 matches
            // and must currently be fit
            return matchesPlayed >= 5 && !injured;
        }

        // Compare players by batting average
        // in descending order
        @Override
        public int compareTo(Player other) {

            return Double.compare(other.battingAverage,this.battingAverage);
        }

        // Getter for player name
        public String getName() {
            return name;
        }

        // Getter for matches played
        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        // Getter for batting average
        public double getBattingAverage() {
            return battingAverage;
        }

        // Getter for injury status
        public boolean isInjured() {
            return injured;
        }
    }

    // Draft eligible players and rank them
    static String draftAndRank(Player[] players) {

        // First count how many players are draftable
        int draftableCount = 0;

        for (Player player : players) {

            if (Player.isDraftable(
                    player.getMatchesPlayed())) {

                draftableCount++;

            } else if (Player.isDraftable(
                    player.getMatchesPlayed(),
                    player.isInjured())) {

                draftableCount++;
            }
        }

        // Create an array of exactly the required size
        Player[] draftablePlayers = new Player[draftableCount];
        int index = 0;
        // Store only draftable players
        for (Player player : players) {

            if (Player.isDraftable(
                    player.getMatchesPlayed())) {

                draftablePlayers[index] = player;
                index++;

            } else if (Player.isDraftable(
                    player.getMatchesPlayed(),
                    player.isInjured())) {

                draftablePlayers[index] = player;
                index++;
            }
        }

        // Arrays.sort uses compareTo()
        Arrays.sort(draftablePlayers);

        // Build the final ranking
        StringBuilder result = new StringBuilder();

        for (int i = 0;i < draftablePlayers.length;i++) {
            result.append((i + 1) + ". " + draftablePlayers[i].getName());
            if (i < draftablePlayers.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        sc.nextLine();

        Player[] players = new Player[n];

        // Take information for each player
        for (int i = 0; i < n; i++) {

            System.out.println(
                    "\nEnter details for Player " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is the player injured? (true/false): ");

            boolean injured = sc.nextBoolean();

            sc.nextLine();

            players[i] = new Player(name,matchesPlayed,battingAverage,injured);
        }

        String result = draftAndRank(players);

        System.out.println("\nFinal Draft Ranking:");

        if (result.isEmpty()) {

            System.out.println("No players are draftable.");

        } else {
            System.out.println(result);
        }

        sc.close();
    }
}