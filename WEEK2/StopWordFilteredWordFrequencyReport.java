import java.util.*;
public class StopWordFilteredWordFrequencyReport {
    // Method to count and display filtered word frequencies
    public void printFilteredWordFrequency(String feedback) {
        // Fixed list of stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        // Convert text to lowercase
        String cleanedText = feedback.toLowerCase();
        // Remove periods and commas
        cleanedText = cleanedText.replace(".", "").replace(",", "");

        // Split the cleaned text into words
        String[] words = cleanedText.split("\\s+");

        // HashMap stores each word and its frequency
        HashMap<String, Integer> frequency = new HashMap<>();

        // Process every word
        for (String word : words) {
            // Check whether the word is a stop word
            boolean isStopWord = false;
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }
            // Skip stop words
            if (isStopWord) {
                continue;
            }
            // Increase the word's frequency
            if (frequency.containsKey(word)) {
                frequency.put(word,frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        // Convert map entries into a list
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        // Sort by frequency in descending order
        entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        // Display the results
        System.out.println("\nWord Frequency Report:");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your feedback paragraph:");
        String feedback = sc.nextLine();
        StopWordFilteredWordFrequencyReport obj = new StopWordFilteredWordFrequencyReport();
        obj.printFilteredWordFrequency(feedback);

        sc.close();
    }
}