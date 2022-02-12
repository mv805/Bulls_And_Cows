package bullscows;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Grader grader = new Grader();
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder();
        input.append(scanner.nextLine());

        StringBuilder secretCode = new StringBuilder("8192");
        grader.gradeCode(secretCode, input);

    }
}
