import model.Outcome;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by rtesta on 12/12/2017.
 */
public class OutcomeTest {

    ArrayList<Outcome> outcomes;

    @Before
    public void setUp() throws Exception {
        outcomes = new ArrayList<>();
        outcomes.add(new Outcome("Red","1:2"));     // 0
        outcomes.add(new Outcome("Black","1:2"));   // 1
        outcomes.add(new Outcome("0","1:56"));      // 2
        outcomes.add(new Outcome("Red","1:2"));     // 3
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Testing the equality method wich acts only on the name, not on the odds
     * @throws Exception
     */
    @Test
    public void isNameEqualToTest() throws Exception {
        assert (!outcomes.get(0).isNameEqualTo(outcomes.get(1)));
        assert (outcomes.get(0).isNameEqualTo(outcomes.get(3)));
        assert (!outcomes.get(1).isNameEqualTo(outcomes.get(2)));
    }

}