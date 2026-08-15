import java.util.*;
public class TrafficSignalStreakAnalyzer {
    public void findLongestStreak(String signalLog) {
        if (signalLog.length() == 0) {
            System.out.println("No traffic signal log found.");
            return;
        }
        
        int currentStreak = 1;
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        char longestColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } else {
                currentStreak = 1;
                currentColor = signalLog.charAt(i);
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = currentColor;
            }
        }
        System.out.println("\nTraffic signal analysis: ");
        System.out.println("Longest streak: " + longestColor + " repeated " + longestStreak + " times.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the traffic signal log (R/Y/G): ");
        String signalLog = sc.nextLine().toUpperCase();
        boolean valid = true;
        for (int i = 0; i < signalLog.length(); i++) {
            char signal = signalLog.charAt(i);
            if (signal != 'R' && signal != 'Y' && signal != 'G') {
                valid = false;
                break;
            }

        }
        if (!valid || signalLog.length() == 0) {
            System.out.println("Invalid traffic signal log. Please enter a valid log containing only R, Y, and G.");
        } else {
            TrafficSignalStreakAnalyzer obj = new TrafficSignalStreakAnalyzer();
            obj.findLongestStreak(signalLog);
        }
    }
}