package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Grader grader = new Grader();
        Scanner scanner = new Scanner(System.in);
        GameState currentState = GameState.PROMPT_CODE;
        StringBuilder secretCode = new StringBuilder();
        StringBuilder input = new StringBuilder();
        String inputString;
        int inputLength;
        int turn = 1;
        boolean gameOver = false;

        while (!gameOver){

            switch (currentState){

                case PROMPT_CODE:
                    System.out.println("Please, enter the secret code's length:");
                    inputLength = Integer.parseInt(scanner.nextLine());
                    if (inputLength > 10){
                        System.out.println("Error: can't generate a secret number with a " +
                                "length of 11 because there aren't enough unique digits");
                        break;
                    } else {
                        System.out.println("Okay, let's start a game!");
                        secretCode = randomCodeGenerator(inputLength);
                        grader.setCodeLength(inputLength);
                        currentState = GameState.TAKE_GUESS;
                    }
                    break;

                case TAKE_GUESS:
                    System.out.printf("Turn %d:%n", turn);
                    inputString = scanner.nextLine();
                    input = new StringBuilder();
                    input.append(inputString);
                    currentState = GameState.GRADE_SCORE;
                    break;

                case GRADE_SCORE:
                    grader.gradeCode(secretCode, input);
                    grader.displayGrade();
                    if (grader.checkGameOver()){
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

    public static StringBuilder randomCodeGenerator(int length) {

        final byte lowerCodeLimit = 0;
        final byte upperCodeLimit = 9;
        int randomNumber;
        StringBuilder secretCode = new StringBuilder();

        secretCode.append(
                GameUtility.randomRangeInteger(1, upperCodeLimit));

        if (length == 1){
            return secretCode;
        }

        for (int i = 0; i < length - 1; i++){
            randomNumber = GameUtility.randomRangeInteger(lowerCodeLimit, upperCodeLimit);

            if (secretCode.indexOf(String.valueOf(randomNumber)) == -1){
                secretCode.append(randomNumber);
            }else {
                i -= 1;
            }
        }

        return secretCode;
    }
}
