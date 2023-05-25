package Model.BasicClasses;

import Model.ICalculable;

public class Bonuses implements ICalculable {

    private String bonus;
    private String description;
    private boolean pays;
    private int quant;

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

    @Override
    public void quantity() {

        this.quant = quant;
    }
}
