package Model.BasicClasses;

public class Taxes {

    private String codeTax;
    private String description;

    public Taxes(String  codeTax, String description) {
        this.codeTax = codeTax;
        this.description = description;
    }

    public String getCodeTax() {
        return codeTax;
    }

    public String getDescription() {
        return description;
    }
}
