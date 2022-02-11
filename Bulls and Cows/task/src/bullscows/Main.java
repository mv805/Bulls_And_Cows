package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] secretCode = {"8","1","9","2"};
        Scanner scanner = new Scanner(System.in);
        Grader grader = new Grader();
        String[] input = scanner.nextLine().split("");
        grader.gradeCode(secretCode, input);

    }
}
