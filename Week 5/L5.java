
import java.util.Arrays;
import java.util.Locale;

class Candidate implements Comparable<Candidate> {

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
        return cgpa >= 7.0;
    }

    // Overloaded eligibility check
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Composite score
    private double getCompositeScore() {
        return cgpa * 10 + codingScore / 2.0;
    }

    // Sort candidates in descending order of composite score
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    // Shortlist and rank candidates
    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa) ||
                isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted[count] = candidate;
                count++;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);

        // Sort using the compareTo() method
        Arrays.sort(shortlisted);

        if (count == 0) {
            return "No candidates shortlisted";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }

            result.append(i + 1)
                  .append(". ")
                  .append(shortlisted[i].name)
                  .append(" (")
                  .append(String.format(
                      Locale.US,
                      "%.1f",
                      shortlisted[i].getCompositeScore()
                  ))
                  .append(")");
        }

        return result.toString();
    }
}

public class L5 {

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
