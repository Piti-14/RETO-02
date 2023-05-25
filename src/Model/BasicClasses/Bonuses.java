package Model.BasicClasses;

public class Bonuses {

    private String bonus;
    private String description;
    private boolean pays;

    public Bonuses(String bonus, String description, boolean pays) {
        this.bonus = bonus;
        this.description = description;
        this.pays = pays;
    }
    public String getBonus() {
        return bonus;
    }
    public String getDescription() {
        return description;
    }
}
