package Model.BasicClasses;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa un empleado.
 */
public class Employee {

    private String nif, name, firstLastname, secondLastname, account, seniority, dept;
    private int ss_number;
    private boolean permanentJob;
    private ProfessionalGroup group;
    private final ArrayList<Bonuses> bonus = new ArrayList<>();

    /**
     * Constructor por defecto de la clase Employee.
     */
    public Employee(){ }

    /**
     * Constructor de la clase Employee.
     *
     * @param nif            NIF del empleado
     * @param name           nombre del empleado
     * @param firstLastname  primer apellido del empleado
     * @param secondLastname segundo apellido del empleado
     * @param account        cuenta del empleado
     * @param ss_number      número de seguridad social del empleado
     * @param seniority      antigüedad del empleado
     * @param permanentJob   indica si el empleado tiene un trabajo permanente
     * @param dept           departamento del empleado
     * @param group          grupo profesional del empleado
     */
    public Employee(String nif, String name, String firstLastname, String secondLastname, String account,
                    int ss_number, String seniority, boolean permanentJob, String dept, ProfessionalGroup group) {
        this.nif = nif;
        this.name = name;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.account = account;
        this.ss_number = ss_number;
        this.seniority = seniority;
        this.permanentJob = permanentJob;

        if (dept == "A" || dept == "C") {
            this.dept = "I.T.";
        } else if (dept == "B") {
            this.dept = "Marketing";
        } else {
            this.dept = "Administration";
        }

        this.group = group;
    }

    /**
     * Agrega bonos al empleado.
     *
     * @param bonuses lista de bonos a agregar
     */
    public void addBonuses(ArrayList<Bonuses> bonuses) {
        this.bonus.addAll(bonuses);
    }

    /**
     * Obtiene el NIF del empleado.
     *
     * @return NIF del empleado
     */
    public String getNIF() {
        return nif;
    }

    /**
     * Establece el NIF del empleado.
     *
     * @param nif NIF del empleado
     */
    public void setNIF(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return nombre del empleado
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param name nombre del empleado
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el primer apellido del empleado.
     *
     * @return primer apellido del empleado
     */
    public String getFirstLastname() {
        return firstLastname;
    }

    /**
     * Establece el primer apellido del empleado.
     *
     * @param firstLastname primer apellido del empleado
     */
    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    /**
     * Obtiene el segundo apellido del empleado.
     *
     * @return segundo apellido del empleado
     */
    public String getSecondLastname() {
        return secondLastname;
    }

    /**
     * Establece el segundo apellido del empleado.
     *
     * @param secondLastname segundo apellido del empleado
     */
    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    /**
     * Obtiene el número de seguridad social del empleado.
     *
     * @return número de seguridad social del empleado
     */
    public int getSS_number() {
        return ss_number;
    }

    /**
     * Establece el número de seguridad social del empleado.
     *
     * @param ss_number número de seguridad social del empleado
     */
    public void setSS_number(int ss_number) {
        this.ss_number = ss_number;
    }

    /**
     * Obtiene la antigüedad del empleado.
     *
     * @return antigüedad del empleado
     */
    public String getSeniority() {
        return seniority;
    }

    /**
     * Establece la antigüedad del empleado.
     *
     * @param seniority antigüedad del empleado
     */
    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    /**
     * Verifica si el empleado tiene un trabajo permanente.
     *
     * @return true si el empleado tiene un trabajo permanente, false de lo contrario
     */
    public boolean getPermanentJob() {
        return permanentJob;
    }

    /**
     * Establece si el empleado tiene un trabajo permanente.
     *
     * @param permanentJob true si el empleado tiene un trabajo permanente, false de lo contrario
     */
    public void setPermanentJob(boolean permanentJob) {
        this.permanentJob = permanentJob;
    }

    /**
     * Obtiene la cuenta del empleado.
     *
     * @return cuenta del empleado
     */
    public String getAccount() {
        return account;
    }

    /**
     * Obtiene el departamento del empleado.
     *
     * @return departamento del empleado
     */
    public String getDept() {
        return dept;
    }

    /**
     * Obtiene el grupo profesional del empleado.
     *
     * @return grupo profesional del empleado
     */
    public ProfessionalGroup getGroup() {
        return group;
    }

    /**
     * Obtiene la lista de bonos del empleado.
     *
     * @return lista de bonos del empleado
     */
    public ArrayList<Bonuses> getBonus() {
        return bonus;
    }

    /**
     * Devuelve una representación en forma de cadena del empleado.
     *
     * @return representación en forma de cadena del empleado
     */
    public String toString() {
        return "Employee: " + name + ", " + firstLastname + ", " + secondLastname +
                ". Account: " + account + "; nº SS: " + ss_number + ". Start date: " + seniority + ". Department: " + dept +
                ". Group: " + group.getName();
    }
}