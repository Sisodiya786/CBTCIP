package Project1;

import java.util.Scanner;

public class ExamService {
    private Question[] questions;
    private int score;
    private long startTime;
    private long duration;

    public ExamService() {
        questions = new Question[] {
            new Question("What is the capital of France?", new String[]{"Paris", "London", "Rome", "Berlin"}, 0),
            new Question("Who wrote '1984'?", new String[]{"George Orwell", "Aldous Huxley", "Mark Twain", "J.K. Rowling"}, 0),
            // Add more questions as needed
        };
        score = 0;
        duration = 60000; // 60 seconds for the example
    }

    public void startExam(Scanner scanner) {
        score = 0;
        startTime = System.currentTimeMillis();

        for (int i = 0; i < questions.length; i++) {
            if (System.currentTimeMillis() - startTime > duration) {
                System.out.println("Time's up! Auto-submitting...");
                break;
            }
            System.out.println("Question " + (i + 1) + ": " + questions[i].getQuestion());
            String[] options = questions[i].getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }
            int answer = scanner.nextInt() - 1;
            if (answer == questions[i].getCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("Exam completed. Your score: " + score + "/" + questions.length);
    }
}
