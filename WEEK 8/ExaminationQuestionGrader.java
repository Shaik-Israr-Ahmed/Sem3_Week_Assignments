import java.util.*;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {
    MCQ(String questionText, String correctAnswer,
        String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TrueFalse extends Question {
    TrueFalse(String questionText, String correctAnswer,
              String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay extends Question {
    Essay(String questionText, String correctAnswer,
          String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matched = 0;

        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String firstPart = parts[0].trim();
            String[] firstTokens = firstPart.split("\\s+");

            String type = firstTokens[0];

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            double points = Double.parseDouble(parts[6].trim());

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQ(
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points
                    );
                    break;

                case "TF":
                    question = new TrueFalse(
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points
                    );
                    break;

                default:
                    question = new Essay(
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points
                    );
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
    }
}