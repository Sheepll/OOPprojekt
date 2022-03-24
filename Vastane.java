package OOPprojekt;

/**
 * Klass Vastane on vastast tähistav klass mis on klassi Karakter alamklass. Vastane katab üle klassi Karakter mõlemad
 * meetodid, tagades et vastane on alati natukene tugevam kui mängija.
 */

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
        currentStrength = M2ng.getLv()*0.3 + currentStrength;
    }
}
