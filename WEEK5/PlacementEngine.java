import java.util.Arrays;

public class PlacementEngine {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        // Constructor
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // CGPA-only eligibility check
        static boolean isEligible(double cgpa) {

            return cgpa >= 7.5;
        }

        // CGPA + coding score eligibility check
        static boolean isEligible(double cgpa, int codingScore) {

            return cgpa >= 6.5 && codingScore >= 60;
        }

        // Calculate composite score
        private double getCompositeScore() {

            return (cgpa * 10) + (codingScore * 0.5);
        }

        // Compare candidates by composite score in descending order
        @Override
        public int compareTo(Candidate other) {

            return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
            );
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        int count = 0;

        // First count eligible candidates
        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa)
                    || Candidate.isEligible(
                        candidate.cgpa,
                        candidate.codingScore)) {

                count++;
            }
        }

        // Create array for shortlisted candidates
        Candidate[] shortlisted = new Candidate[count];

        int index = 0;

        // Add eligible candidates
        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa)
                    || Candidate.isEligible(
                        candidate.cgpa,
                        candidate.codingScore)) {

                shortlisted[index] = candidate;
                index++;
            }
        }

        // Sort using Candidate's compareTo()
        Arrays.sort(shortlisted);

        String result = "";

        // Build final output
        for (int i = 0; i < shortlisted.length; i++) {

            Candidate candidate = shortlisted[i];

            result = result
                    + (i + 1)
                    + ". "
                    + candidate.name
                    + " ("
                    + candidate.getCompositeScore()
                    + ")";

            if (i < shortlisted.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

            new Candidate("Aisha", 8.2, 40),

            new Candidate("Rohit", 6.8, 65),

            new Candidate("Meena", 6.0, 90),

            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(candidates);

        System.out.println(result);
    }
}