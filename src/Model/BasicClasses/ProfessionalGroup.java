package Model.BasicClasses;

public class ProfessionalGroup {

    private String groupCode;
    private double quant;

    public ProfessionalGroup(String groupCode, double quant) {
        this.groupCode = groupCode;
        this.quant = quant;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }
}
