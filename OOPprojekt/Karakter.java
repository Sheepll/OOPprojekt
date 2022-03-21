package OOPprojekt;

public class Karakter {
    private String nimi;
    private int currentHealth;
    private double currentStrength;
    int currentLevel;

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public double getCurrentStrength() {
        return currentStrength;
    }

    public void setCurrentStrength(double currentStrength) {
        this.currentStrength = currentStrength;
    }

    public String getNimi() { return nimi;}

    public void setNimi(String nimi) { this.nimi = nimi;}

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Karakter(String nimi, int currentHealth, double currentStrength, int currentLevel) {
        this.currentHealth = currentHealth;
        this.currentStrength = currentStrength;
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
