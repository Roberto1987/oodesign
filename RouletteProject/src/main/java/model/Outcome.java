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

    /**
     * Object equality using hashcode, considering both odds and name
     * @return
     */

    public boolean isEqualTo(Outcome c){
        String cDesc = c.getName()+c.getOdds();
        String thisDesc = descCompose();
        return (cDesc.hashCode()==thisDesc.hashCode());
    }

    public String getName() {
        return name;
    }

    /**
     * Compare the name of the odds
     * @param o
     * @return TRUE if the names are the same, FALSE otherwise
     */
    public boolean isNameEqualTo(Outcome o){
        return this.name.equals(o.getName());
    }

    /**
     * Return the hashCode for the string describint the outcome object
     * @return
     */
    public int getHashCode(){
        String thisDesc = descCompose();
        return thisDesc.hashCode();
    }

    /**
     * Compose a string representation of the object, independent from the reference.
     * @return
     */
    private String descCompose() {
        return this.odds+this.name;
    }
}
