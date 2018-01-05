package model;


import customException.KeyAlreadyContainedException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by rtesta on 18/12/2017.
 */
public class WheelTest {

    Wheel wheel;
    Bin[] bins;
    Outcome o1,o2,o3;

    @Before
    public void setUp() throws Exception {
        wheel = Wheel.getInstance();
        wheel.reset();
         o1 = new Outcome("Red","2:1");
         o2 = new Outcome("Red","2:1");
         o3 = new Outcome("Black","2:1");
    }

    @Test(expected = KeyAlreadyContainedException.class)
    public void addDuplicateOutcomeToBin() throws Exception {
        wheel.addOutcomeToBin(o1,0);
        wheel.addOutcomeToBin(o2,0);
    }

    @Test
    public void addOutcomesToBinTest() throws Exception {
        wheel.addOutcomeToBin(o1,0);
        wheel.addOutcomeToBin(o3,0);
    }

}