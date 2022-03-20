package OOPprojekt;

public class Karakter {
    private double strengthModifer;
    private int healthModifier;
    private String nimi;
    private int currentHealth = 50;
    private double currentStrength = 1.0;
    int currentLevel = 1;

    public int getBaseHealth() {
        return currentHealth;
    }

    public double getBaseStrength() { return currentStrength;}

    public String getNimi() { return nimi;}

    public void setNimi(String nimi) { this.nimi = nimi;}

    public int getHealthModifier() { return healthModifier;}

    public void setHealthModifier(int healthModifier) { this.healthModifier = healthModifier;}

    public double getStrengthModifer() { return strengthModifer;}

    public void setStrengthModifer(double strengthModifer) { this.strengthModifer = strengthModifer;}

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Karakter(double strengthModifer, int healthModifier, String nimi, int currentHealth, double currentStrength, int currentLevel) {
        this.strengthModifer = strengthModifer;
        this.currentHealth = currentHealth;
        this.currentStrength = currentStrength;
        this.healthModifier = healthModifier;
        this.nimi = nimi;
        this.currentLevel = currentLevel;
    }

    void healthUp(){
        currentHealth = currentLevel+currentHealth;
    }
    void strengthUp(){
        currentStrength = currentLevel*0.2 + currentStrength;
    }
}
