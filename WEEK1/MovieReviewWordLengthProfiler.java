import java.util.Scanner;
public class MovieReviewWordLengthProfiler {
    public void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        for (String word : words) {
            int length = word.length();
            if (length >= 1 && length <= 4) {
                shortWords++;
            } else if (length >= 5 && length <= 8) {
                mediumWords++;
            } else if (length >= 9) {
                longWords++;
            }
        }
        System.out.println("\nMovie Review Word Length Analysis:");
        System.out.println("Short words (1-4 characters): " + shortWords);
        System.out.println("Medium words (5-8 characters): " + mediumWords);
        System.out.println("Long words (9+ characters): " + longWords);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a movie review:");
        String review = sc.nextLine();

        if (review.trim().isEmpty()) {
            System.out.println("No review provided.");
        } else {
            MovieReviewWordLengthProfiler obj = new MovieReviewWordLengthProfiler();
            obj.classifyWordLengths(review);
        }
    }
}