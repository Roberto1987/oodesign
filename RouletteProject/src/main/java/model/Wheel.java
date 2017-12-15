package model;

import Global.Constant;
import customException.KeyAlreadyContainedException;

/**
 * Created by rtesta on 13/12/2017.
 * Roulette wheels, randomly pick one of the 37 possible bins.
 *
 */
public class Wheel {

    private Bin[] bins;

    private RandomGenerator randomGenerator;

    public Wheel(){
        randomGenerator = RandomGenerator.getInstance();
        bins = new Bin[Constant.NUMBER_OF_BINS];
    }

    /**
     * Add an Outcome o to a Bin i = 0,...,37
     * @param o
     * @param binNumber
     */
    public void addOutcomeToBin(Outcome o, int binNumber){
        try {
            bins[binNumber].put(o);
        } catch (KeyAlreadyContainedException e) {
            e.printStackTrace();
            System.out.println("Element already inserted");
        }
        finally {

        }
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

}
