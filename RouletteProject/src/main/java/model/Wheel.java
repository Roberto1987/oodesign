package model;

import Global.Constant;
import customException.KeyAlreadyContainedException;

/**
 * Created by rtesta on 13/12/2017.
 * Roulette wheels, randomly pick one of the 37 possible bins.
 * bin(0) -> 1, ... bin(35)-> 36, bin(36)-> 0, bin(37)-> 00
 *
 * Only one Wheel must exists, then is implemented as Singleton.
 *
 */
public class Wheel {

    private static volatile Wheel instance = null;

    private Bin[] bins;

    private RandomGenerator randomGenerator;

    private Wheel(){
        randomGenerator = RandomGenerator.getInstance();
        bins = new Bin[Constant.NUMBER_OF_BINS];
        for(int i = 0; i<bins.length;i++){
            bins[i] = new Bin();
        }

    }

    /**
     * Implemented with lazy initialization
     */
    public static Wheel getInstance() {
        if (instance == null) {
            synchronized(Wheel.class) {
                if (instance == null) {
                    instance = new Wheel();
                }
            }
        }
        return instance;
    }

    /**
     * Add an Outcome o to a Bin i = 0,...,37
     * @param o
     * @param binNumber
     */
    public void addOutcomeToBin(Outcome o, int binNumber) throws KeyAlreadyContainedException {
          bins[binNumber].put(o);
      }


    public Bin getBin(int binNumber){
        return bins[binNumber];
    }

    /**
     * Return a random Bin
     * @return
     */
    public Bin getRandomBin(){
        return bins[randomGenerator.generateRandNum()];
    }

    /**
     * Reset the Wheel object
     */
    public void reset(){
        instance = new Wheel();
    }

}
