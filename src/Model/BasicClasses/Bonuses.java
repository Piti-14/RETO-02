package Model.BasicClasses;

import Model.ICalculable;

public class Bonuses {

    private String bonusCode;
    private String description;
    //private boolean pays;
    private double quant;

    public Bonuses(String bonusCode, String description, double quant) {
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
    public double getQuant() {
        return quant;
    }

    public String toString() {
        return bonusCode + ", " + description + ". Quantity: " + quant;
    }
}
