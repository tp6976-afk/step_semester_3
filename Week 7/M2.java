
class M2 {
    private final boolean[] results;
    private int answersRecorded;

    public M2(int totalQuestions) {
        results = new boolean[totalQuestions];
        answersRecorded = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (answersRecorded < results.length) {
            results[answersRecorded] = isCorrect;
            answersRecorded++;
        } else {
            System.out.println("All answers have been recorded");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        M2 sc = new M2(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Total Score: " + sc.getScore());
    }
}
