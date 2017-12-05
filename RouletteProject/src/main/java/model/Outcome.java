package model;

/**
 * Created by rtesta on 04/12/2017.
 *
 * Define an outcome, with the odds and the name of the outcome
 */
public class Outcome {

    private String odds;
    private String name;

    /**
     *
     * @param odds
     * @param name
     */
    public Outcome( String name, String odds) {
        this.odds = odds;
        this.name = name;
    }

    public String getOdds() {
        return odds;
    }

    public String getName() {
        return name;
    }

    /**
     * Compare the name of the odds
     * @param o
     * @return TRUE if the names are the same, FALSE otherwise
     */
    public boolean isEqualTo(Outcome o){
        return this.name.equals(o.getName());
    }
}
