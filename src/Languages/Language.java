package Languages;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class Language extends Properties{
    public static final int spanish = 0;
    public static final int english = 1;
    public Language(int lang) throws URISyntaxException {
        switch (lang) {
            case spanish -> getProperties(String.valueOf(Configuration.getConfigFilePath("espanol.properties")));
            case english -> getProperties(String.valueOf(Configuration.getConfigFilePath("english.properties")));
            default -> getProperties(String.valueOf(Configuration.getConfigFilePath("espanol.properties")));
        }
    }

    public void getProperties(String langFile) {
        try {
            System.out.println(langFile);
            this.load( new FileInputStream(langFile));
        } catch (IOException ignored) {
            System.out.println("Error language");


        }
    }
}