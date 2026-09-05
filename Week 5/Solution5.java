import java.util.Arrays;

public class Solution5 {

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

        // Overloaded isEligible() - CGPA only
        static boolean isEligible(double cgpa) {
            return cgpa >= 8.0;
        }

        // Overloaded isEligible() - CGPA + coding score
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 7.0 && codingScore >= 20;
        }

        // Compare candidates by composite score in descending order
        @Override
        public int compareTo(Candidate other) {

            double thisScore = cgpa * 10 + codingScore * 0.5;
            double otherScore = other.cgpa * 10 + other.codingScore * 0.5;

            return Double.compare(otherScore, thisScore);
        }

        // Calculate composite score
        double getCompositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        // Shortlist and rank candidates
        static String shortlistAndRank(Candidate[] candidates) {

            Candidate[] shortlisted = new Candidate[candidates.length];
            int count = 0;

            for (Candidate candidate : candidates) {

                boolean eligible;

                // Direct CGPA eligibility
                if (isEligible(candidate.cgpa)) {
                    eligible = true;
                }
                // Borderline CGPA eligibility
                else {
                    eligible = isEligible(candidate.cgpa, candidate.codingScore);
                }

                if (eligible) {
                    shortlisted[count] = candidate;
                    count++;
                }
            }

            // Create array containing only shortlisted candidates
            Candidate[] result = Arrays.copyOf(shortlisted, count);

            // Uses Candidate.compareTo()
            Arrays.sort(result);

            String output = "";

            for (int i = 0; i < result.length; i++) {

                output += (i + 1) + ". "
                       + result[i].name
                       + " (" + result[i].getCompositeScore() + ")";

                if (i < result.length - 1) {
                    output += " | ";
                }
            }

            return output;
        }
    }

    public static void main(String[] args) {

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(
            Candidate.shortlistAndRank(candidates)
        );
    }
}