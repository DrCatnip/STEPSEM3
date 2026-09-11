import java.util.Arrays;
import java.util.Scanner;

public class FantasyTeamScoreMultiplier {

    // Apply captain and vice-captain multipliers
    // directly to the original array
    static void applyMultipliers(double[] playerScores, int captainIndex,int viceCaptainIndex) {
        // Captain gets 2 times the original score
        playerScores[captainIndex] = playerScores[captainIndex] * 2;
        // Vice-captain gets 1.5 times the original score
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        double[] playerScores = new double[n];
        System.out.println("Enter the scores of the players:");
        for (int i = 0; i < n; i++) {
            System.out.print("Score of player " + i + ": ");
            playerScores[i] = sc.nextDouble();
        }

        System.out.print("Enter captain index: ");
        int captainIndex = sc.nextInt();
        System.out.print("Enter vice-captain index: ");
        int viceCaptainIndex = sc.nextInt();

        // Apply the required multipliers
        applyMultipliers( playerScores, captainIndex, viceCaptainIndex );

        System.out.println( "Updated player scores: " + Arrays.toString(playerScores));
        sc.close();
    }
}