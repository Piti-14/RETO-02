package Model.BasicClasses;

/**
 * Clase que representa una empresa.
 */
public class Company {

    private final String cif;
    private final String name;
    private final String address;
    private final int ccc;

    /**
     * Constructor de la clase Company.
     *
     * @param cif     CIF de la empresa
     * @param name    nombre de la empresa
     * @param address dirección de la empresa
     * @param ccc     número de cuenta bancaria de la empresa
     */
    public Company(String cif, String name, String address, int ccc) {
        this.cif = cif;
        this.name = name;
        this.address = address;
        this.ccc = ccc;
    }

    /**
     * Obtiene el CIF de la empresa.
     *
     * @return CIF de la empresa
     */
    public String getCif() {
        return cif;
    }

    /**
     * Obtiene el nombre de la empresa.
     *
     * @return nombre de la empresa
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la dirección de la empresa.
     *
     * @return dirección de la empresa
     */
    public String getAddress() {
        return address;
    }

    /**
     * Obtiene el número de cuenta bancaria de la empresa.
     *
     * @return número de cuenta bancaria de la empresa
     */
    public int getCcc() {
        return ccc;
    }

    /**
     * Retorna una representación en cadena de texto del objeto Company.
     *
     * @return representación en cadena de texto del objeto Company
     */
    public String toString() {
        return name + ", " + address + ". CIF: " + cif + "; " + "CCC: " + ccc;
    }
}
