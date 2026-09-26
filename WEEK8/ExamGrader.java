import java.util.*;
import java.util.regex.*;

abstract class Question {

    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(
        String questionText,
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();

    public abstract String getType();
}

class MCQQuestion extends Question {

    public MCQQuestion(
        String questionText,
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        super(
            questionText,
            correctAnswer,
            studentAnswer,
            points
        );
    }

    @Override
    public double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {

    public TFQuestion(
        String questionText,
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        super(
            questionText,
            correctAnswer,
            studentAnswer,
            points
        );
    }

    @Override
    public double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    @Override
    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {

    public EssayQuestion(
        String questionText,
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        super(
            questionText,
            correctAnswer,
            studentAnswer,
            points
        );
    }

    @Override
    public double calculateScore() {

        String[] keywords = correctAnswer.split(",");

        int matchedKeywords = 0;

        String studentText =
            studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (studentText.contains(keyword)) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75;
        } else if (matchedKeywords == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class ExamGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            List<String> values = extractQuotedStrings(line);

            String type = line.substring(
                0,
                line.indexOf(" ")
            );

            String questionText = values.get(0);
            String correctAnswer = values.get(1);
            String studentAnswer = values.get(2);

            String[] parts = line.trim().split("\\s+");

            double points =
                Double.parseDouble(parts[parts.length - 1]);

            if (type.equals("MCQ")) {

                questions[i] =
                    new MCQQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    );

            } else if (type.equals("TF")) {

                questions[i] =
                    new TFQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    );

            } else if (type.equals("ESSAY")) {

                questions[i] =
                    new EssayQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                    );
            }
        }

        double totalScore = 0;

        for (Question question : questions) {

            double score = question.calculateScore();

            System.out.printf(
                "%s: %.2f%n",
                question.getType(),
                score
            );

            totalScore += score;
        }

        System.out.printf(
            "Total Score: %.2f%n",
            totalScore
        );

        sc.close();
    }

    // Extract text inside quotation marks
    public static List<String> extractQuotedStrings(String line) {

        List<String> values = new ArrayList<>();

        Pattern pattern =
            Pattern.compile("\"([^\"]*)\"");

        Matcher matcher =
            pattern.matcher(line);

        while (matcher.find()) {
            values.add(matcher.group(1));
        }

        return values;
    }
}