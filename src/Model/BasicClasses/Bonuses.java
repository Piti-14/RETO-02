package Model.BasicClasses;

/**
 * Clase que representa un bono.
 */
public class Bonuses {

    private final String bonusCode;
    private final String description;
    private final double quant;

    /**
     * Constructor de la clase Bonuses.
     *
     * @param bonusCode   código del bono
     * @param description descripción del bono
     * @param quant       cantidad del bono
     */
    public Bonuses(String bonusCode, String description, double quant) {
        this.bonusCode = bonusCode;
        this.description = description;
        this.quant = quant;
    }

    /**
     * Obtiene el código del bono.
     *
     * @return código del bono
     */
    public String getBonusCode() {
        return bonusCode;
    }

    /**
     * Obtiene la descripción del bono.
     *
     * @return descripción del bono
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene la cantidad del bono.
     *
     * @return cantidad del bono
     */
    public double getQuant() {
        return quant;
    }

    /**
     * Retorna una representación en cadena de texto del objeto Bonuses.
     *
     * @return representación en cadena de texto del objeto Bonuses
     */
    public String toString() {
        return bonusCode + ", " + description + ". Quantity: " + quant;
    }
}
