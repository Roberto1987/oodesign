package model;

import customException.KeyAlreadyContainedException;
import org.junit.Test;

/**
 * Created by rtesta on 13/12/2017.
 */
public class BinTest {
    /**
     * Check if it throws an exception if two identical elements are inserted.
     * @throws Exception
     */
    @Test(expected = KeyAlreadyContainedException.class)
    public void putSameElementTest() throws Exception {
        Outcome o1 = new Outcome("red","1:2");
        Outcome o2 = new Outcome("red","1:2");
        Bin bin = new Bin();
        bin.put(o1);
        bin.put(o2);
    }

    @Test
    public void putSomeElementsTest() throws Exception{
        Outcome o1 = new Outcome("red","1:2");
        Outcome o2 = new Outcome("black","1:2");
        Bin bin = new Bin();
        bin.put(o1);
        bin.put(o2);
        System.out.println(bin);
    }

}