package model;

import Global.Constant;

import java.util.Random;

/**
 * Created by rtesta on 13/12/2017.
 * Random generator, implement as Singleton to simulate a single random source.
 */
public class RandomGenerator {

    private static volatile RandomGenerator instance = null;

    private Random r;

    private RandomGenerator() {
        r = new Random();
    }


    public static RandomGenerator getInstance() {
        if (instance == null) {
            synchronized(RandomGenerator.class) {
                if (instance == null) {
                    instance = new RandomGenerator();
                }
            }
        }
        return instance;
    }

    /**
     * Generate a random number between 0 and 37
     * @return
     */
    public int generateRandNum(){
        return r.nextInt(Constant.NUMBER_OF_BINS);
    }
}
