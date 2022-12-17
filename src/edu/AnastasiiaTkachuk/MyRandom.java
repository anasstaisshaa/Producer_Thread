package edu.AnastasiiaTkachuk;
import java.util.Random;
public final class MyRandom {
    private static final Random RANDOM = new Random();
    private static final int DEFAULT_BOUND = 10;

    public static int getRandom() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

}
