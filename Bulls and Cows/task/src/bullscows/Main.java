package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Grader grader = new Grader();
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder();
        input.append(scanner.nextLine());

        StringBuilder secretCode = new StringBuilder("9305");
        grader.gradeCode(secretCode, input);

    }
}
