package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rtesta on 07/12/2017.
 */
public class TranslationPrinter {

    String path = "output.txt";

    /**
     * Print the list of translation in a file located in the path String.
     * @param arr
     * @throws IOException
     */
    public void printToFile(ArrayList<String> arr) throws IOException {

        FileWriter writer = new FileWriter(path);
        for(String str: arr) {
            writer.write(" "+str+", \n");
        }
        writer.close();
    }
}
