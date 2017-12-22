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
            int rand = r.generateRandNum();
            if (rand>=39 || rand<0 ) {
                System.out.println("Random number out of range: "+rand);

            }
        }
    }

}