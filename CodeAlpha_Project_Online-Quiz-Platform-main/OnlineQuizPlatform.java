import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());

            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Your answer (1-" + options.size() + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == question.getCorrectOption() + 1) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " +
                        (question.getCorrectOption() + 1) + ". " + options.get(question.getCorrectOption()) + "\n");
            }
        }

        System.out.println("Quiz completed. Your score: " + score + "/" + questions.size());
    }
}

public class OnlineQuizPlatform {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Who is the national animal of india?",
                List.of("Giraffe", "Dog", "Tiger", "Cow"), 2));
        questions.add(new Question("Who is the  CEO of Microsoft?",
                List.of("Satya Nadella", "Elon Musk", "Sundar Pichai", "Bill Gates"), 0));
        // Add more questions

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
