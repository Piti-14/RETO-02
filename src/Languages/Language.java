package Languages;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * Clase que representa el idioma.
 */
public class Language extends Properties {
    public static final int SPANISH = 0;
    public static final int ENGLISH = 1;

    /**
     * Constructor de la clase Language.
     *
     * @param lang entero que representa el idioma a utilizar
     * @throws URISyntaxException si ocurre un error en la sintaxis de la URI
     */
    public Language(int lang) throws URISyntaxException {
        switch (lang) {
            case SPANISH -> getProperties(String.valueOf(Configuration.getConfigFilePath("espanol.properties")));
            case ENGLISH -> getProperties(String.valueOf(Configuration.getConfigFilePath("english.properties")));
            default -> getProperties(String.valueOf(Configuration.getConfigFilePath("espanol.properties")));
        }
    }

    /**
     * Obtiene las propiedades del archivo de idioma especificado.
     *
     * @param langFile ruta del archivo de idioma
     */
    public void getProperties(String langFile) {
        try {
            this.load(new FileInputStream(langFile));
        } catch (IOException ignored) {
            System.out.println("Error language");
        }
    }
}