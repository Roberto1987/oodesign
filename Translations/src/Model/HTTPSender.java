package Model;

import main.GlobalContants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rtesta on 07/12/2017.
 */
public class HTTPSender {

    /**
     * Sending the http request with the word to translate, the languages from translate from and to,
     * formed depending which api is in use.
     *
     * @param word  word to translate
     * @param transFrom     original language
     * @param transTo       language to translate
     * @param api_label     api used
     * @return  Translated word
     * @throws IOException
     */
    public String httpSendRequest(String word, String transFrom, String transTo, String api_label) throws IOException {

        if(word.isEmpty()){
            word = "empty word";
        }
        word = checkForSpacing(word);
       String response = getStringFromInputStream(retrieveTranslation(httpRequestCreation(word,transFrom,transTo,api_label) ));
        return traslationPostProcessing(response,api_label);
    }

    /**
     * HttpRequest creation
     * @param api_label  Type of translator
     * @param word    Word to tranlsate
     * @param transFrom   Original language
     * @param transTo  Language to translate in
     * @return
     */
    public String httpRequestCreation(String word,String transFrom, String transTo,String api_label){
        String httpRequest = null;
        if(api_label.equals(GlobalContants.YANDEX_LABEL)){
             String commonPrefixRequest =GlobalContants.YANDEX_COMMON_PREFIX;
             httpRequest = commonPrefixRequest+ GlobalContants.YANDEX_KEY+"&text="+word+"&lang="+
                    transFrom+"-"+transTo;
        }
        else{
            String commonPrefixRequest =GlobalContants.MYMEMORY_COMMON_PREFIX;
            httpRequest = commonPrefixRequest+word+"&langpair="+transFrom+"|"
                    +transTo+"&de="+GlobalContants.MYMEMORY_MAIL;
        }

        return httpRequest;
    }

    /**
     * Formatting the string: depending which api is used the returning string will be in different format.
     * @param response
     * @param api_label
     * @return
     */
    public String traslationPostProcessing(String response, String api_label){
        if(api_label.equals(GlobalContants.YANDEX_LABEL)){
            String[] words = response.split("\\[");
            response = cleanString(words[1]);
        }
        else{
            response = cleanString(response);
            String[] words = response.split(":");
            String[] secondSplit = words[2].split(",");
            response = secondSplit[0];
            response = cleanTranslation(response);
        }
        return response;
    }

    /**
     * Format the space with the %20 to make it compatible with http request standard.
     * @param word
     * @return
     */
    private String checkForSpacing(String word) {
         return word = word.replace(" ","%20");
    }

    /**
     * Cleaning the string from parentesis and apices.
     * @param word
     * @return
     */
    private static String cleanString(String word){
        word = word.replace('{',' ');
        word = word.replace('[',' ');
        word = word.replace(']',' ');
        word = word.replace('}',' ');
        word = word.replace('"',' ');
        return word;
    }

    /**
     * Cleaning the '%' produced by spacing in the http response.
     * @param translation
     * @return
     */
    private static String cleanTranslation(String translation){
        translation = translation.replace("%","");
        return translation;
    }

    /**
     * Retrieve the translated word/phrase sending the httpRequest
     * @param httpRequest
     * @return
     * @throws IOException
     */
    public InputStream retrieveTranslation(String httpRequest) throws IOException {
        HttpURLConnection connection = null;
        try{
            URL url = new URL(httpRequest);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
        }
         catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }
        return connection.getInputStream();
    }

    /**
     * Transform the input stream in Strings
     * @param
     * @return
     */
    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
