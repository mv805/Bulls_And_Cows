package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeBuilder {

    public static final Scanner scanner = new Scanner(System.in);

    private List<Character> secretCodeList = new ArrayList<>();
    private final StringBuilder secretCode = new StringBuilder();
    private int codeLength;
    private int numberOfSymbols;

    public StringBuilder getSecretCode() {
        return secretCode;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void promptCodeLength() {

        final int maxCodeLength = 36;

        while (true) {
            System.out.println("Please, enter the secret code's length:");
            int inputLength = Integer.parseInt(scanner.nextLine());

            if (inputLength > maxCodeLength) {
                System.out.println("Error: can't generate a secret number with a " +
                        "length of " + maxCodeLength + " because there " +
                        "aren't enough unique digits");
            } else {
                this.codeLength = inputLength;
                break;
            }
        }
    }

    public void promptSymbolLength() {

        final int maxSymbolLength = 36;

        while (true) {
            System.out.println("Input the number of possible symbols " +
                    "in the code: ");
            int numberOfSymbols = Integer.parseInt(scanner.nextLine());

            if (numberOfSymbols > maxSymbolLength) {
                System.out.println("Error: can't generate a secret number with more " +
                        "than " + maxSymbolLength + " symbols");
            } else {
                this.numberOfSymbols = numberOfSymbols;
                break;
            }
        }
    }

    public void createSecretCode() {

        List<Character> secretCodeListImmutable = List.of('0', '1', '2', '3',
                '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z');

        secretCodeList.addAll(secretCodeListImmutable);

        secretCodeList = secretCodeList.subList(0, codeLength);
        Collections.shuffle(secretCodeList);

        for (Character item : secretCodeList) {
            secretCode.append(item);
        }

    }

    public void displaySecretCodeInfo() {
        final int letterACharASCII = 97;
        final int totalNumbersInCode = 10;

        System.out.print("The secret is prepared: ");
        for (int i = 0; i < secretCodeList.size(); i++) {
            System.out.print("*");
        }

        String lastChar = Character.toString(letterACharASCII +
                numberOfSymbols - totalNumbersInCode - 1);
        System.out.printf(" (0-9, a-%s).%n", lastChar);

    }


}
