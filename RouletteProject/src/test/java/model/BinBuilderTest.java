package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rtesta on 20/12/2017.
 */
public class BinBuilderTest {

    BinBuilder binBuilder;
    Wheel wheel;

    @Before
    public void setUp() throws Exception {
        binBuilder = BinBuilder.getBinBuilder();
        wheel = new Wheel();
    }

    @Test
    public void genStraightBet() throws Exception {


    }

    @Test
    public void splitBetLeftColumn() throws Exception {
    }

}