package Model.BasicClasses;

/**
 * Clase que representa un impuesto.
 */
public class Taxes {

    private final String codeTax;
    private final String description;

    /**
     * Constructor de la clase Taxes.
     *
     * @param codeTax     código del impuesto
     * @param description descripción del impuesto
     */
    public Taxes(String codeTax, String description) {
        this.codeTax = codeTax;
        this.description = description;
    }

    /**
     * Obtiene el código del impuesto.
     *
     * @return código del impuesto
     */
    public String getCodeTax() {
        return codeTax;
    }

    /**
     * Obtiene la descripción del impuesto.
     *
     * @return descripción del impuesto
     */
    public String getDescription() {
        return description;
    }
}