package Controller;

import java.io.IOException;
import java.util.Properties;

public class Language extends Properties{
    public static final int spanish = 0;
    public static final int english = 1;
    public Language(int lang){
        switch (lang) {
            case spanish -> getProperties("/espanol.properties");
            case english -> getProperties("/english.properties");
            default -> getProperties("/espanol.properties");
        }
    }

    private void getProperties(String langFile) {
        try {
            this.load( getClass().getResourceAsStream(langFile) );

        } catch (IOException ignored) {

        }
    }
    public void changeLanguage(int newLang){
        Language language = new Language(newLang);

    }
}