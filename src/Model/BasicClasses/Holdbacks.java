package Model.BasicClasses;

/**
 * Clase que representa un descuento.
 */
public class Holdbacks {

    private final String codeH;
    private final String description;

    /**
     * Constructor de la clase Holdbacks.
     *
     * @param codeH       código del descuento
     * @param description descripción del descuento
     */
    public Holdbacks(String codeH, String description) {
        this.codeH = codeH;
        this.description = description;
    }

    /**
     * Obtiene el código del descuento.
     *
     * @return código del descuento
     */
    public String getCodeH() {
        return codeH;
    }

    /**
     * Obtiene la descripción del descuento.
     *
     * @return descripción del descuento
     */
    public String getDescription() {
        return description;
    }
}