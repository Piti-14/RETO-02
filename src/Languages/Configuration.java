package Languages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class Configuration {
    private static final String FILE_PROPERTIES = String.valueOf(Configuration.class.getResource("Configuration.properties")).substring(5);

    private Properties properties;

    public Configuration() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(FILE_PROPERTIES);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLanguage(String value) {
        properties.setProperty("Language", value);
        try {
            FileOutputStream file = new FileOutputStream(FILE_PROPERTIES);
            properties.store(file, null);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLanguage() {
        return properties.getProperty("Language");
    }

    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        // Establecer el valor de Language
        configuration.setLanguage("1");

        // Obtener el valor de Language
        String language = configuration.getLanguage();
        System.out.println("Valor de Language: " + language);
        configuration.setLanguage("0");
        System.out.println("Valor de Language: " + configuration.getLanguage());

        String prueba = String.valueOf(Configuration.class.getResource("Configuration.properties"));


    }
}