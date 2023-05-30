package Model.BasicClasses;

public class ProfessionalGroup {

    private String groupCode;
    private String name;
    private double quant;

    public ProfessionalGroup(String name, String groupCode) {
        this.groupCode = groupCode;
        this.name = name;
        //this.quant = quant;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }
}
