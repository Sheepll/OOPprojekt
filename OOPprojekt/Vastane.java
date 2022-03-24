package OOPprojekt;

public class Vastane extends Karakter {

    public Vastane(String nimi, int currentHealth, double currentStrength) {
        super(nimi, currentHealth, currentStrength);
    }

    @Override
    void healthUp(){
        currentHealth = M2ng.getLv()+currentHealth+2;
    }
    @Override
    void strengthUp(){
        currentStrength = M2ng.getLv()*0.15 + currentStrength;
    }
}
