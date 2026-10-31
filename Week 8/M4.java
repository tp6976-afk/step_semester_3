```java
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String correctAnswer, String studentAnswer,
             double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();
}

class MCQQuestion extends Question {
    MCQQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    @Override
    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TFQuestion extends Question {
    TFQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    @Override
    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    @Override
    double evaluate() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int matches = 0;

        for (String keyword : keywords) {
            String word = keyword.trim().toLowerCase();

            if (!word.isEmpty() && answer.contains(word)) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class M4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            String type = line.substring(0, line.indexOf(' '));
            Matcher matcher = pattern.matcher(line);

            String[] fields = new String[3];
            int count = 0;
            int lastEnd = 0;

            while (matcher.find()) {
                if (count < 3) {
                    fields[count++] = matcher.group(1);
                }
                lastEnd = matcher.end();
            }

            double points = Double.parseDouble(
                    line.substring(lastEnd).trim());

            Question question;

            switch (type.toUpperCase()) {
                case "MCQ":
                    question = new MCQQuestion(
                            fields[1], fields[2], points);
                    break;

                case "TF":
                    question = new TFQuestion(
                            fields[1], fields[2], points);
                    break;

                case "ESSAY":
                    question = new EssayQuestion(
                            fields[1], fields[2], points);
                    break;

                default:
                    continue;
            }

            double score = question.evaluate();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
```