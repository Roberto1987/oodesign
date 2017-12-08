package main;

import Model.HTTPSender;
import Model.TextExtractor;
import Model.TranslationPrinter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rtesta on 07/12/2017.
 */
public class Main {

    private ArrayList<String> translations;



    private String api_label;

    public static void main(String[] args)  {
        Main main = new Main();
        main.setApi_label(GlobalContants.YANDEX_LABEL);

        HTTPSender httpSender = new HTTPSender();
        //httpSender.yandexMemoryhttpSendRequest("Big");
       // main.tranlsateWithYandex();
        System.out.println("Translating with: "+main.getApi_label());
        main.translate(main.api_label);

    }

    public void translate(String api_label){

        translations = new ArrayList<String>();
        HTTPSender httpSender = new HTTPSender();
        TextExtractor textExtractor = new TextExtractor();
        try {
            textExtractor.extract();
            TranslationPrinter translationPrinter = new TranslationPrinter();
            translations = textExtractor.getList();
            int i = 0;
            for(i = 0; i<translations.size();i++){
                translations.set(i,httpSender.httpSendRequest(translations.get(i),GlobalContants.ENGLISH,GlobalContants.ITALIAN,api_label));
                System.out.println(translations.get(i));
            }

            translationPrinter.printToFile(translations);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setApi_label(String api_label) {
        this.api_label = api_label;
    }

    public String getApi_label() {
        return api_label;
    }
}
