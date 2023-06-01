package Languages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Language extends Properties{
    public static final int spanish = 0;
    public static final int english = 1;
    public Language(int lang){
        switch (lang) {
            case spanish -> getProperties(String.valueOf(Configuration.class.getResource("espanol.properties")).substring(5));
            case english -> getProperties(String.valueOf(Configuration.class.getResource("english.properties")).substring(5));
            default -> getProperties(String.valueOf(Configuration.class.getResource("espanol.properties")).substring(5));
        }
    }

    private void getProperties(String langFile) {
        try {
            this.load( new FileInputStream(langFile));
        } catch (IOException ignored) {
            System.out.println("Error language");
        }
    }
}