package Model;

public class Department {

    private String codeDept;
    private String name;

    public Department(String codeDept, String name) {
        this.codeDept = codeDept;
        this.name = name;
    }

    public String getCodeDept() {
        return codeDept;
    }

    public String getName() {
        return name;
    }
}
