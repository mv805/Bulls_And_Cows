package bullscows;

import java.util.Random;

public class GameUtility {

    static Random random = new Random();

    public static int randomRangeInteger(int lowerLimit, int upperLimit){

        return random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

    }
}
