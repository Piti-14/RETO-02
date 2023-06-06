package Languages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Clase que representa la configuración del idioma.
 */
public class Configuration {
    private final Properties properties;
    private static final String CONFIGFILE = "Configuration.properties";
    private static final String FILE_PROPERTIES;

    static {
        try {
            FILE_PROPERTIES = String.valueOf(getConfigFilePath(CONFIGFILE).toUri()).substring(7);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Constructor de la clase Configuration.
     *
     * @throws URISyntaxException si ocurre un error en la sintaxis de la URI
     */
    public Configuration() throws URISyntaxException {
        properties = new Properties();

        try {
            FileInputStream file = new FileInputStream(FILE_PROPERTIES);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Establece el idioma.
     *
     * @param value valor del idioma a establecer
     */
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

    /**
     * Obtiene el idioma actualmente configurado.
     *
     * @return idioma actualmente configurado
     */
    public String getLanguage() {
        return properties.getProperty("Language");
    }

    /**
     * Obtiene la ruta del archivo de configuración.
     *
     * @param file nombre del archivo de configuración
     * @return ruta del archivo de configuración
     * @throws URISyntaxException si ocurre un error en la sintaxis de la URI
     */
    static Path getConfigFilePath(String file) throws URISyntaxException {
        String jarPath = Configuration.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        String parentDir = new File(jarPath).getParent();
        return Paths.get(parentDir, file);
    }
}