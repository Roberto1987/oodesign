package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rtesta on 07/12/2017.
 */
public class TextExtractor {

    private String path ="C:\\Users\\rtesta\\Downloads\\TestTranslations.txt";

    private ArrayList<String> list;

    public ArrayList<String> getList() {
        return list;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



    /**
     * Extract the phrases to translate from a txt file, each phrases for line
     *
     * @return ArrayList<String> containing all the phrases
     * @throws FileNotFoundException
     */
    public List extract() throws FileNotFoundException {
        Scanner s = new Scanner(new File(path));
        list = new ArrayList<String>();

        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();

        int nOfLine = list.size()+1;
        System.out.println("lines founds: "+nOfLine);
        return list;
    }

}
