package customException;

/**
 * Created by rtesta on 13/12/2017.
 */
public class KeyAlreadyContainedException extends Exception {
    public KeyAlreadyContainedException(String description) {
        System.out.println("Outcome already inserted."+description);
    }
}
