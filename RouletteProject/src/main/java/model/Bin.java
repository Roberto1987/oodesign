package model;

import customException.KeyAlreadyContainedException;

import java.util.HashMap;

/**
 * Created by rtesta on 13/12/2017.
 *
 * Container of Outcomes. Each number element of the roulette has its own bin.
 * Each outcome must be unique in the collection.
 * The bin elements must not be mutable.
 */
public class Bin extends HashMap<String,Outcome>{


    /**
     * Add an outcome of the collection
     * @param o Outcome
     * @throws KeyAlreadyContainedException if the Outcome is already in the bin
     */
    public void put(Outcome o) throws KeyAlreadyContainedException {
        if (super.containsKey(o.getDescription()))
        {
            throw new KeyAlreadyContainedException();
        }
    super.put(o.getDescription(),o);
    }
}
