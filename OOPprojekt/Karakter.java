package OOPprojekt;

public class Karakter {
    private double strengthModifer;
    private int healthModifier;
    private String nimi;
    private int baseHealth = 50;
    private double baseStrength = 1.0;

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }
}
