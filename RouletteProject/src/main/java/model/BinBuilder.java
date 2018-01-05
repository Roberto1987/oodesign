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

     private BinBuilder(){
         wheel = Wheel.getInstance();
     }

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
        wheel.getBin(Constant.NUMBER_OF_BINS-1).put(new Outcome(Constant.DOUBLE_ZERO,"1:35"));
    }

    /**
     * Implementation of bet regarding couple of number adjacent to each other,
     * For example:
     *              4 --> 4-1, 4-5, 4-7.
     *              5--> 5-4, 5-2, 5-6, 5-8.
     * The number of split bet in which a number can be involved vary between
     * numbers: for example 5 is involved in more split bet cause is in the
     * central column of the roulette's board.
     * @throws KeyAlreadyContainedException
     */
    public void splitBet() throws KeyAlreadyContainedException {
        String odds = Constant.SPIT_BET_ODDS;
        int limitNumber = 4;
        //Left column: for each cell, upper-right-down neighbour
        for(int i = 4;i<Constant.NUMBER_OF_BINS-limitNumber;i=i+3){

            int nextBin = i+1;
            int upperBin= i-3;
            int lowerBin= i+3;

            wheel.getBin(i).put(new Outcome(""+i+"-"+nextBin,odds));
            wheel.getBin(i).put(new Outcome(""+i+"-"+upperBin,odds));
            wheel.getBin(i).put(new Outcome(""+i+"-"+lowerBin,odds));
        }

        //Central column: for each cell, upper-right-left-down neighbour
        for(int i = 5;i<Constant.NUMBER_OF_BINS-limitNumber;i=i+3){

            int nextBin = i+1;
            int upperBin= i-3;
            int lowerBin= i+3;
            int prevBin = i-1;

            wheel.getBin(i).put(new Outcome(""+i+"-"+nextBin,odds));
            wheel.getBin(i).put(new Outcome(""+i+"-"+upperBin,odds));
            wheel.getBin(i).put(new Outcome(""+i+"-"+lowerBin,odds));
            wheel.getBin(i).put(new Outcome(""+i+"-"+prevBin,odds));
        }

        //right column: for each cell, upper-right-down neighbour
        for(int i = 6;i<Constant.NUMBER_OF_BINS-limitNumber;i=i+3){

            int upperBin= i-3;
            int lowerBin= i+3;
            int prevBin = i-1;

            wheel.getBin(i).put(new Outcome(""+i+"-"+upperBin,odds));
            wheel.getBin(i).put(new Outcome(""+i+"-"+lowerBin,odds));
            wheel.getBin(i).put(new Outcome(""+i+"-"+prevBin,odds));
        }
        // Number still out: 1,2,3 - 34,35,36

        // bin 1
        String one ="1";
        wheel.getBin(1).put(new Outcome(""+one+"-"+2,odds));
        wheel.getBin(1).put(new Outcome(""+one+"-"+4,odds));

        //bin 2
        String two = "2";
        wheel.getBin(2).put(new Outcome(""+two+"-"+1,odds));
        wheel.getBin(2).put(new Outcome(""+two+"-"+3,odds));
        wheel.getBin(2).put(new Outcome(""+two+"-"+5,odds));

        //bin 3
        String three ="3";
        wheel.getBin(3).put(new Outcome(""+three+"-"+2,odds));
        wheel.getBin(3).put(new Outcome(""+three+"-"+6,odds));

        // bin 34
        String thirtyFour ="34";
        wheel.getBin(34).put(new Outcome(""+thirtyFour+"-"+31,odds));
        wheel.getBin(34).put(new Outcome(""+thirtyFour+"-"+35,odds));

        //bin 35
        String thirtyFive = "35";
        wheel.getBin(35).put(new Outcome(""+thirtyFive+"-"+32,odds));
        wheel.getBin(35).put(new Outcome(""+thirtyFive+"-"+34,odds));
        wheel.getBin(35).put(new Outcome(""+thirtyFive+"-"+36,odds));

        //bin 36
        String thirtySix ="36";
        wheel.getBin(36).put(new Outcome(""+thirtySix+"-"+33,odds));
        wheel.getBin(36).put(new Outcome(""+thirtySix+"-"+35,odds));


    }

}
