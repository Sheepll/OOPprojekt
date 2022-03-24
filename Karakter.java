package OOPprojekt;

import javax.swing.*;

public class Karakter {
    int currentHealth;
    double currentStrength;
    String nimi;

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

    public Karakter(String nimi, int currentHealth, double currentStrength) {
        this.currentHealth = currentHealth;
        this.currentStrength = currentStrength;
        this.nimi = nimi;
    }

    void healthUp(){
        currentHealth = M2ng.getLv() +currentHealth;
    }
    void strengthUp(){
        currentStrength = M2ng.getLv()*0.2 + currentStrength;
    }
}
