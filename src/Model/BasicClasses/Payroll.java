package Model.BasicClasses;

/**
 * Clase que representa una nómina.
 */
public class Payroll {

    private String id, nif;
    private int year;
    private int month;
    private double netPay;
    private double taxPay;
    private double companyPay;
    Employee e;

    /**
     * Constructor de la clase Payroll.
     *
     * @param e     empleado asociado a la nómina
     * @param year  año de la nómina
     * @param month mes de la nómina
     */
    public Payroll(Employee e, int year, int month) {
        this.e = e;
        this.nif = e.getNIF();
        this.year = year;
        this.month = month;

        this.id = e.getName() + "_" + e.getFirstLastname() + "_" + month + "_" + year;
    }
}
