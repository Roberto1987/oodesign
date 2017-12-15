package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rtesta on 13/12/2017.
 */
public class RandomGeneratorTest {
    @Test
    public void generateRandNumCorrectOutputTest() throws Exception {
        RandomGenerator r = RandomGenerator.getInstance();
        for(int i=0;i<10000;i++){
            if (r.generateRandNum()>=37 || r.generateRandNum()<0 ) assert false;
        }
    }

}