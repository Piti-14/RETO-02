package Model.BasicClasses;

public class Company {

    private String cif;
    private String name;
    private String address;
    private int ccc;

    public Company(String cif, String name, String address, int ccc) {
        this.cif = cif;
        this.name = name;
        this.address = address;
        this.ccc = ccc;
    }

    public String getCif() {
        return cif;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCcc() {
        return ccc;
    }

    public String toString() {
        return name + ", " + address + ". CIF: " + cif + "; " + "CCC: " + ccc;
    }
}
