class QuizScorecard {
    private boolean[] results;
    private int recordedCount;

    public QuizScorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < results.length) {
            results[recordedCount] = isCorrect;
            recordedCount++;
        } else {
            System.out.println("All questions are already recorded");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public int getRecordedCount() {
        return recordedCount;
    }
}

public class Practice2_QuizScorecard {
    public static void main(String[] args) {
        QuizScorecard quiz = new QuizScorecard(4);

        quiz.recordAnswer(true);
        quiz.recordAnswer(true);
        quiz.recordAnswer(false);
        quiz.recordAnswer(true);

        System.out.println("Total score: " + quiz.getScore());
        System.out.println("Recorded answers: " + quiz.getRecordedCount());

        quiz.recordAnswer(false);
    }
}