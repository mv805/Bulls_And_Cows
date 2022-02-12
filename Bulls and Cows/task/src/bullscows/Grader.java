package bullscows;

public class Grader {

    private int bulls = 0;
    private int cows = 0;
    private int codeLength;

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public void gradeCode(StringBuilder secretCode, StringBuilder playerInput) {

        for (int i = 0; i < playerInput.length(); i++) {
            if (playerInput.charAt(i) == secretCode.charAt(i)) {
                bulls++;
            }
            for (int j = 0; j < secretCode.length(); j++) {
                if (playerInput.charAt(i) != secretCode.charAt(i) &&
                        playerInput.charAt(i) == secretCode.charAt(j)) {
                    cows++;
                }
            }
        }
        displayGrade(secretCode);
    }

    public void displayGrade(StringBuilder secretCode) {

        System.out.print("Grade: ");

        if (bulls == 4 || (bulls > 0 && cows == 0)) {
            System.out.printf("%d bull(s).%n", bulls);
        } else if (bulls > 0 && cows > 0) {
            System.out.printf("%d bull(s) and %d cow(s).%n", bulls, cows);
        } else if (bulls == 0 && cows > 0) {
            System.out.printf("%d cow(s).%n", cows);
        } else {
            System.out.print("None.%n");
        }
    }

    public boolean checkGameOver(){
        if (bulls == codeLength){
            return true;
        }
        bulls = 0;
        cows = 0;
        return false;
    }


}
