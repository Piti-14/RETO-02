package Model.BasicClasses;

/**
 * Clase que representa un grupo profesional.
 */
public class ProfessionalGroup {

    private String groupCode;
    private String name;
    private double quant;

    /**
     * Constructor de la clase ProfessionalGroup.
     *
     * @param name      nombre del grupo profesional
     * @param groupCode código del grupo profesional
     */
    public ProfessionalGroup(String name, String groupCode) {
        this.groupCode = groupCode;
        this.name = name;
        //this.quant = quant;
    }

    /**
     * Obtiene el código del grupo profesional.
     *
     * @return código del grupo profesional
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * Establece el código del grupo profesional.
     *
     * @param groupCode código del grupo profesional
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    /**
     * Obtiene el nombre del grupo profesional.
     *
     * @return nombre del grupo profesional
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del grupo profesional.
     *
     * @param name nombre del grupo profesional
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la cantidad del grupo profesional.
     *
     * @return cantidad del grupo profesional
     */
    public double getQuant() {
        return quant;
    }

    /**
     * Establece la cantidad del grupo profesional.
     *
     * @param quant cantidad del grupo profesional
     */
    public void setQuant(double quant) {
        this.quant = quant;
    }
}
