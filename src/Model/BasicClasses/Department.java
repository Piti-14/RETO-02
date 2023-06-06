package Model.BasicClasses;

/**
 * Clase que representa un departamento.
 */
public class Department {

    private final String codeDept;
    private final String name;

    /**
     * Constructor de la clase Department.
     *
     * @param codeDept código del departamento
     * @param name     nombre del departamento
     */
    public Department(String codeDept, String name) {
        this.codeDept = codeDept;
        this.name = name;
    }

    /**
     * Obtiene el código del departamento.
     *
     * @return código del departamento
     */
    public String getCodeDept() {
        return codeDept;
    }

    /**
     * Obtiene el nombre del departamento.
     *
     * @return nombre del departamento
     */
    public String getName() {
        return name;
    }
}