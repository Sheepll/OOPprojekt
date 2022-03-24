package OOPprojekt;

import javax.swing.*;
import java.util.Objects;

public class  M2ng {
    Karakter m2ngija;
    Vastane vastane;
    static int lv = 1;
    String[] nimed;
    int nimeluger = 0;

    public M2ng(Karakter m2ngija, Vastane vastane,String[] nimed) {
        this.m2ngija = m2ngija;
        this.vastane = vastane;
        this.nimed = nimed;

    }

    public static int getLv() {
        return lv;
    }

    public static double Damage(){
        int min = 1;
        int max = 10;
        return (int)(Math.random() * (max - min + 1) + min);
    }

    public  void action() throws InterruptedException {
     while(nimeluger < nimed.length) {
         int m2ngijaElud = m2ngija.getCurrentHealth();
         int vastaseElud = vastane.getCurrentHealth();

         System.out.println(m2ngija.getNimi() + " VS " + vastane.getNimi());
         while (vastaseElud > 0 & m2ngijaElud > 0) {
             m2ngijaElud -= (int) Damage();
             System.out.println(m2ngija.getNimi() + " HP: " + m2ngijaElud);
             Thread.sleep(500);
             vastaseElud -= (int) Damage();
             System.out.println("Vastase HP: " + vastaseElud);
             Thread.sleep(500);
         }

         if (m2ngijaElud < vastaseElud) {
             System.out.println(m2ngija.getNimi() + " kaotas..");
             try {
                 Thread.sleep(50);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             break;
         }

         lv++;
         nimeluger++;
         if(nimeluger == nimed.length){
             System.out.println("Palju 6nne!" + m2ngija.getNimi() +" v6itis turnamendi ja palju raha.");
             break;
         }
         String valik = JOptionPane.showInputDialog(null, "Kas soovid elusid v6i tugevust? (Sisesta oma valik v2ikeste t2htedega samas kirjapildis)", "Valik", JOptionPane.QUESTION_MESSAGE);
         if (Objects.equals(valik, "tugevust")) {
             m2ngija.strengthUp();
         } else {
             m2ngija.healthUp();
         }
         vastane.healthUp();
         vastane.strengthUp();
         vastane.setNimi(nimed[nimeluger]);
     }
    }

}
