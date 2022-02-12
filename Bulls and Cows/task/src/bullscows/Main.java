package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Grader grader = new Grader();
        Scanner scanner = new Scanner(System.in);

        //StringBuilder input = new StringBuilder();
        //input.append(scanner.nextLine());

        //StringBuilder secretCode = new StringBuilder("9305");
        //grader.gradeCode(secretCode, input);
        int inputLength = scanner.nextInt();
        randomGenerator(inputLength);

    }

    public static void randomGenerator(int length) {

        if (length > 10){
            System.out.println("Error: can't generate a secret number with a " +
                    "length of 11 because there aren't enough unique digits");
            return;
        }

        StringBuilder secretCode = new StringBuilder();

        List<Integer> randomList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        while (randomList.get(0) == 0) {
            Collections.shuffle(randomList);
        }

        for (int i = 0; i < length; i++){
            secretCode.append(randomList.get(i));
        }

        System.out.printf("The random secret number is %s", secretCode);
    }
}
