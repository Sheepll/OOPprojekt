


/**
 * Klass Karakter on mängija tegelast väljendav klass, kus on parameetrid currentHealth (mängija HP, millega ta iga
 * võitlust alustab), currentStrength(mängija tugevus, millega ta iga võitlust alustab) ja nimi, mis on kasutaja poolt
 * vabalt valitud sõne.
 *
 * Klassis on kaks meetodit mis tõstavad mängija HP'd ja tugevust, olenevalt sellest kumma kasutaja valis.
 *
 * Parameeter currentStrength mõjutab suvaliselt genereeritud löögi tugevust, näiteks kui genereeritakse arv 10 ja
 * tugevus on 1.2, teeb mängija 12 elupunkti väärtuses kahju.
 */

public class Karakter {
    private int currentHealth;
    private double currentStrength;
    private String nimi;

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

    void healthUp(int lv){
        currentHealth = lv +currentHealth;
    }
    void strengthUp(int lv){
        currentStrength = lv*0.2 + currentStrength;
    }
}
