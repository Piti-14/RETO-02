package Model.BasicClasses;

import Model.ICalculable;

public class Bonuses {

    private String bonusCode;
    private String description;
    //private boolean pays;
    private int quant;

    public Bonuses(String bonusCode, String description, int quant) {
        this.bonusCode = bonusCode;
        this.description = description;
        this.quant = quant;
    }
    public String getBonusCode() {
        return bonusCode;
    }
    public String getDescription() {
        return description;
    }
    public int getQuant() {
        return quant;
    }

    public String toString() {
        return bonusCode + ", " + description + ". Quantity: " + quant;
    }
}
