import java.util.Scanner;

interface Question {
    double calculateScore();
    String getType();
}

class MCQQuestion implements Question {

    private String questionText;
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    public MCQQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {

        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TFQuestion implements Question {

    private String questionText;
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    public TFQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {

        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "TF";
    }
}

class EssayQuestion implements Question {

    private String questionText;
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    public EssayQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {

        String[] keywords =
                correctAnswer.split(",");

        String answer =
                studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

class QuestionFactory {

    public static Question createQuestion(
            String type,
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        switch (type) {

            case "MCQ":
                return new MCQQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);

            case "TF":
                return new TFQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);

            case "ESSAY":
                return new EssayQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);

            default:
                throw new IllegalArgumentException(
                        "Invalid question type");
        }
    }
}

public class Practice4_QuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts =
                    line.split("\"");

            String type =
                    parts[0].trim().split(" ")[0];

            String questionText =
                    parts[1];

            String correctAnswer =
                    parts[3];

            String studentAnswer =
                    parts[5];

            double points =
                    Double.parseDouble(
                            parts[6].trim());

            Question question =
                    QuestionFactory.createQuestion(
                            type,
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points);

            double score =
                    question.calculateScore();

            System.out.printf(
                    "%s: %.2f%n",
                    question.getType(),
                    score);

            totalScore = totalScore + score;
        }

        System.out.printf(
                "Total Score: %.2f%n",
                totalScore);

        sc.close();
    }
}