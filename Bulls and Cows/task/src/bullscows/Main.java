package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Grader grader = new Grader();
        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        StringBuilder secretCode;
        StringBuilder input;

        while (true){
            System.out.println("Please, enter the secret code's length:");
            int inputLength = scanner.nextInt();
            if (inputLength > 10){
                System.out.println("Error: can't generate a secret number with a " +
                        "length of 11 because there aren't enough unique digits");
            } else {
                System.out.println("Okay, let's start a game!");
                secretCode = randomGenerator(inputLength);
                grader.setCodeLength(inputLength);
                break;
            }
        }

        System.out.printf("Turn %d:%n", turn);

        while (true){

            String inputString = scanner.nextLine();
            input = new StringBuilder(inputString);
            grader.gradeCode(secretCode, input);
            if (grader.checkGameOver()){
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            turn++;
            System.out.printf("Turn %d:%n", turn);
        }
    }

    public static StringBuilder randomGenerator(int length) {

        StringBuilder secretCode = new StringBuilder();

        List<Integer> randomList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        while (randomList.get(0) == 0) {
            Collections.shuffle(randomList);
        }

        for (int i = 0; i < length; i++){
            secretCode.append(randomList.get(i));
        }

        return secretCode;
    }
}
