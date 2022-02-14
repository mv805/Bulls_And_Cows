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

        int inputLength;
        System.out.println("Input the length of the secret code:");
        String inputString = scanner.nextLine();
        try {
            inputLength = Integer.parseInt(inputString);
        } catch (Exception e){
            System.out.printf("Error: \"%s\" isn't a valid number.", inputString);
            Main.gameOver = true;
            return;
        }
        this.codeLength = inputLength;
    }

    public void promptSymbolLength() {

        System.out.println("Input the number of possible symbols " +
                "in the code: ");
        int numberOfSymbols = Integer.parseInt(scanner.nextLine());

        if (numberOfSymbols < codeLength || codeLength == 0) {
            System.out.printf("Error: it's not possible to generate a code " +
                    "with a length of %d with %d unique symbols.", codeLength
            , numberOfSymbols);
            Main.gameOver = true;
        } else if (numberOfSymbols > 36){
            System.out.println("Error: maximum number of possible symbols in" +
                    " the code is 36 (0-9, a-z).");
            Main.gameOver = true;
        } else {
            this.numberOfSymbols = numberOfSymbols;
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
