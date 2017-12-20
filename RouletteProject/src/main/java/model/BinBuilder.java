package model;

import Global.Constant;
import customException.KeyAlreadyContainedException;
import jdk.nashorn.internal.objects.Global;

/**
 * Created by rtesta on 19/12/2017.
 *
 * Injecting all possible outcomes in the bins. As a builder, should be a singleton.
 * Using lazy initialization paradigm.
 *
 */
public class BinBuilder {
     Wheel wheel;
     private static BinBuilder binBuilder;

     private BinBuilder(){}

     public static synchronized BinBuilder getBinBuilder(){
         if (binBuilder==null) {
             binBuilder = new BinBuilder();
         }
         return binBuilder;
     }



    /**
     * Generate all the straight bet, a.k.a. 1,2,3,....,36
     * @throws KeyAlreadyContainedException
     */
    public void genStraightBet() throws KeyAlreadyContainedException {
        for(int i = 1; i< Constant.NUMBER_OF_BINS-1;i++){
            wheel.getBin(i).put(new Outcome(""+i,"1:35"));
        }
    }

    /**
     * Create bets for Zero
     * @throws KeyAlreadyContainedException
     */
    public void zero() throws KeyAlreadyContainedException {
        wheel.getBin(0).put(new Outcome(Constant.ZERO,"1:35"));
    }

    /** Create bets for Double Zero
     *
     * @throws KeyAlreadyContainedException
     */
    public void doubleZero() throws KeyAlreadyContainedException {
        wheel.getBin(36).put(new Outcome(Constant.DOUBLE_ZERO,"1:35"));
    }

    public void splitBetLeftColumn() throws KeyAlreadyContainedException {

        //Left column: for each cell, upper-right-down neighbour
        for(int i = 4;i<Constant.NUMBER_OF_BINS-3;i=i+3){

            int nextBin = i+1;
            int upperBin= i-3;
            int lowerBin= i+3;

            wheel.getBin(i).put(new Outcome(""+i+"-"+nextBin,"2:35"));
            wheel.getBin(i).put(new Outcome(""+i+"-"+upperBin,"2:35"));
            wheel.getBin(i).put(new Outcome(""+i+"-"+lowerBin,"2:35"));
        }

        //Central column: for each cell, upper-right-left-down neighbour
        for(int i = 5;i<Constant.NUMBER_OF_BINS-3;i=i+3){

            int nextBin = i+1;
            int upperBin= i-3;
            int lowerBin= i+3;
            int prevBin = i-1;

            wheel.getBin(i).put(new Outcome(""+i+"-"+nextBin,"2:35"));
            wheel.getBin(i).put(new Outcome(""+i+"-"+upperBin,"2:35"));
            wheel.getBin(i).put(new Outcome(""+i+"-"+lowerBin,"2:35"));
            wheel.getBin(i).put(new Outcome(""+i+"-"+prevBin,"2:35"));
        }

        //right column: for each cell, upper-right-down neighbour
        for(int i = 6;i<Constant.NUMBER_OF_BINS-3;i=i+3){

            int upperBin= i-3;
            int lowerBin= i+3;
            int prevBin = i-1;

            wheel.getBin(i).put(new Outcome(""+i+"-"+upperBin,"2:35"));
            wheel.getBin(i).put(new Outcome(""+i+"-"+lowerBin,"2:35"));
            wheel.getBin(i).put(new Outcome(""+i+"-"+prevBin,"2:35"));
        }

        // Number still out: 1,2,3 - 34,35,36

    }

}
