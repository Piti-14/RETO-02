package Model.BasicClasses;

public class Holdbacks {

    private String codeH;
    private String description;

    public Holdbacks(String codeH, String description) {
        this.codeH = codeH;
        this.description = description;
    }

    public String getCodeH() {
        return codeH;
    }

    public String getDescription() {
        return description;
    }
}
