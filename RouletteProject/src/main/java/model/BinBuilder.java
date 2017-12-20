package model;

import Global.Constant;
import customException.KeyAlreadyContainedException;
import jdk.nashorn.internal.objects.Global;

/**
 * Created by rtesta on 19/12/2017.
 */
public class BinBuilder {
     Wheel wheel;

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
        for(int i = 3;i<Constant.NUMBER_OF_BINS-6;i=i+3){
            int nextBin = i+1;
            int upperBin= i-3;
            int lowerBin= i+3;
            String nextBinOutcomeName = "Split "+i+","+nextBin;



        }

    }

}
