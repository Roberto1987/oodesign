package model;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by rtesta on 05/12/2017.
 */
public class OutcomeTest {
    Outcome o1,o2,o3;

    @Before
    public void setUp() throws Exception {
        o1 = new Outcome("Red","1:2" );
        o2 = new Outcome("Black","1:2");
        o3 = new Outcome("Red","1:4");
    }

    @org.junit.Test
    public void isEqualTo() throws Exception {
        assert (!o1.isEqualTo(o2));
        assert (o1.isEqualTo(o3));
        assert (!o2.isEqualTo(o3));
    }

}