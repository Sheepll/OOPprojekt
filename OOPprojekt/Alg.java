package OOPprojekt;

import javax.swing.JOptionPane;
import java.util.Objects;

public class Alg {

    public static double Damage(){
        int min = 1;
        int max = 10;
        return (int)(Math.random() * (max - min + 1) + min);
    }

    public static void main(String[] args) throws InterruptedException {
        String karakteriNimi = JOptionPane.showInputDialog(null, "Sisestage oma karakteri nimi","Nimi",JOptionPane.QUESTION_MESSAGE);
        int lv = 1;
        String[] nimed = {"Algaja lohe", "Noor lohe","Roheline lohe", "Kogenud lohe", "Lohekuningas"};
        int nimeluger = 0;
        Karakter m2ngija = new Karakter(karakteriNimi,50,1.0,lv);
        Vastane lohe = new Vastane(nimed[nimeluger],40,1.2,lv);

        while(nimeluger < nimed.length) {
            int m2ngijaElud = m2ngija.getCurrentHealth();
            int vastaseElud = lohe.getCurrentHealth();

            System.out.println(karakteriNimi + " VS " + lohe.getNimi());
            while (vastaseElud > 0 & m2ngijaElud > 0) {
                m2ngijaElud -= (int) Damage();
                System.out.println(karakteriNimi + " HP: " + m2ngijaElud);
                Thread.sleep(500);
                vastaseElud -= (int) Damage();
                System.out.println("Vastase elud: " + vastaseElud);
                Thread.sleep(500);
            }

            if (m2ngijaElud < vastaseElud) {
                System.out.println(karakteriNimi +  " kaotas..");
                Thread.sleep(50);
                break;
            }

            lv++;
            m2ngija.setCurrentLevel(lv);
            lohe.setCurrentLevel(lv);
            String valik = JOptionPane.showInputDialog(null, "Kas soovid elusid v6i tugevust? (Sisesta oma valik v2ikeste t2htedega samas kirjapildis)", "Valik", JOptionPane.QUESTION_MESSAGE);
            if (Objects.equals(valik, "tugevust")) {
                m2ngija.strengthUp();
            }
            else{
                m2ngija.healthUp();
            }
            lohe.healthUp();
            lohe.strengthUp();
            nimeluger++;
            lohe.setNimi(nimed[nimeluger]);
        }

    }
}

