package bullscows;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Grader grader = new Grader();

        GameState currentState = GameState.PROMPT_CODE;
        StringBuilder input = new StringBuilder();
        CodeBuilder codeBuilder = new CodeBuilder();

        String inputString;
        int turn = 1;
        boolean gameOver = false;

        while (!gameOver) {

            switch (currentState) {

                case PROMPT_CODE:
                    codeBuilder.promptCodeLength();
                    codeBuilder.promptSymbolLength();
                    codeBuilder.createSecretCode();
                    codeBuilder.displaySecretCodeInfo();
                    System.out.println(codeBuilder.getSecretCode());
                    System.out.println("Okay, let's start a game!");
                    grader.setCodeLength(codeBuilder.getCodeLength());
                    currentState = GameState.TAKE_GUESS;
                    break;
                case TAKE_GUESS:
                    System.out.printf("Turn %d:%n", turn);
                    inputString = scanner.nextLine();
                    input = new StringBuilder();
                    input.append(inputString);
                    currentState = GameState.GRADE_SCORE;
                    break;

                case GRADE_SCORE:
                    grader.gradeCode(codeBuilder.getSecretCode(), input);
                    grader.displayGrade();
                    if (grader.checkGameOver()) {
                        currentState = GameState.END_GAME;
                        break;
                    } else {
                        turn++;
                        grader.resetBullsAndCows();
                        currentState = GameState.TAKE_GUESS;
                    }
                    break;

                case END_GAME:
                    System.out.println("Congratulations! You guessed the secret code.");
                    gameOver = true;
                    break;

            }
        }
    }

}
