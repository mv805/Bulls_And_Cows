package bullscows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Grader {

    int bulls = 0;
    int cows = 0;
    List<String> secretCode = new ArrayList<>();
    List<String> playerInput = new ArrayList<>();

    public void gradeCode(String[] secretCode, String[] playerInput) {

        this.secretCode = Arrays.asList(secretCode);
        this.playerInput = Arrays.asList(playerInput);

        for (String number : this.playerInput) {
            cows += Collections.frequency(this.secretCode, number);
        }

        for (int i = 0; i < this.playerInput.size(); i++) {
            if (this.playerInput.get(i).equals(this.secretCode.get(i))){
                bulls++;
                cows--;
            }
        }
        displayGrade();
    }

    public void displayGrade() {

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

        System.out.print("The secret code is ");
        secretCode.forEach(System.out::print);
        System.out.print(".");
    }
}
