package bullscows;

public class Grader {

    int bulls = 0;
    int cows = 0;

    public void gradeCode(StringBuilder secretCode, StringBuilder playerInput) {

        for (int i = 0; i < playerInput.length(); i++){
            if (playerInput.charAt(i) == secretCode.charAt(i)){
                bulls++;
            }
            for (int j = 0; j < secretCode.length(); j++){
                if (playerInput.charAt(i) != secretCode.charAt(i) &&
                        playerInput.charAt(i) == secretCode.charAt(j)){
                    cows++;
                }
            }
        }

        displayGrade(secretCode);
    }

    public void displayGrade(StringBuilder secretCode) {

        System.out.print("Grade: ");

        if (bulls == 4){
            System.out.printf("%d bull(s). ", bulls);
        } else if (bulls > 0 && cows > 0){
            System.out.printf("%d bull(s) and %d cow(s). ", bulls, cows);
        } else if (cows > 0){
            System.out.printf("%d cow(s). ", cows);
        } else {
            System.out.print("None. ");
        }

        System.out.printf("The secret code is %s", secretCode);
    }
}
