package Model;

public class Payroll {

    private String id;
    private String nif;
    private int year;
    private int month;
    private double netPay;
    private double taxPay;
    private double companyPay;
    Employee e;

    public Payroll(Employee e, int year, int month) {
        this.e = e;
        this.nif = e.getNIF();
        this.year = year;
        this.month = month;

        this.id = e.getName() + "_" + e.getFirstLastname() + "_" + month + "_" + year;
    }
}
