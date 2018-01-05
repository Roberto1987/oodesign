package model;

import Global.Constant;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by rtesta on 20/12/2017.
 */
public class BinBuilderTest {

    BinBuilder binBuilder;

    @Before
    public void setUp() throws Exception {
        binBuilder = BinBuilder.getBinBuilder();
    }

    @Test
    public void genStraightBet() throws Exception {
        binBuilder.genStraightBet();
        binBuilder.doubleZero();
        binBuilder.zero();
        for(int i = 0; i< Constant.NUMBER_OF_BINS;i++){
            System.out.println("BIN "+i+": "+Wheel.getInstance().getBin(i).printBin());
        }



    }

    @Test
    public void splitBet() throws Exception {
        binBuilder.splitBet();
        for(int i = 0; i< Constant.NUMBER_OF_BINS;i++){
            System.out.println("BIN "+i+": "+Wheel.getInstance().getBin(i).printBin());
        }
    }

}