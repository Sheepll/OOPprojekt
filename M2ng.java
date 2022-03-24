package OOPprojekt;

import javax.swing.*;
import java.util.Objects;

/**
 * Klass M2ng on mängu läbiviiv klass, kus on parameetrid m2ngija ja vastane, kes üksteise vastu võitlevad ning
 * parameetrid lv, nimed ja nimeluger, mida kasutatakse mängu kulgemise jälgimiseks ning õigeaegselt mängu lõpetamiseks.
 */

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


    /**
     * Meetod Damage genereerib suvalise arvu vahemikus 1-10 mida Karakter ja Vastane kasutavad enda rünnaku tugevuse
     * tähistamiseks.
     * @return  Tagastab suvalise arvu vahemikus 1-10.
     */
    public static double Damage(){
        int min = 1;
        int max = 10;
        return (int)(Math.random() * (max - min + 1) + min);
    }

    /**
     * Meetod action viib läbi mängu peamist osa, milleks on kahe tegelase vahel toimuv võitlus. Selleks kasutatakse antud
     * parameetreid ning meetodit Damage. Mäng kestab seni, kuni on kas vastaseid, kellega võidelda või mängija kaotab.
     * Meetod Damage'i tagastatud arv korrutatakse mängija ja vastase enda tugevuse kordajatega, mis muutuvad peale igat
     * tsüklit (vastasel iga tsükkel ühtlaselt ning mängijal olenevalt kasutaja valikutest).
     * @throws InterruptedException juhul kui Thread.sleep funktsiooniga tuleb probleeme.
     */

    public  void action() throws InterruptedException {
     while(nimeluger < nimed.length) {
         int m2ngijaElud = m2ngija.getCurrentHealth();
         int vastaseElud = vastane.getCurrentHealth();

         System.out.println(m2ngija.getNimi() + " kohtas metsas ohtlikku looma " + vastane.getNimi() + "!");
         Thread.sleep(1000);
         System.out.println(m2ngija.getNimi() + " VS " + vastane.getNimi());
         while (vastaseElud > 0 & m2ngijaElud > 0) {
             m2ngijaElud -= (int) Damage()*vastane.getCurrentStrength();
             System.out.println(m2ngija.getNimi() + " HP: " + m2ngijaElud);
             if(m2ngijaElud <= 0){
                 break;
             }
             //Sleep aitab kasutajal paremini võitluse tempot jälgida.
             Thread.sleep(1000);
             vastaseElud -= (int) Damage()*m2ngija.getCurrentStrength();
             System.out.println( vastane.getNimi() + " HP: " + vastaseElud);
             Thread.sleep(1000);
         }

         System.out.println("#".repeat(20));

         if (m2ngijaElud <= 0) {
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
             System.out.println("Palju õnne! " + m2ngija.getNimi() +" saavutas võidu looduse üle ja saab naasta linna.");
             break;
         }
         String valik = JOptionPane.showInputDialog(null, "Kui soovid tõsta tugevust, sisesta STR, kui elusid siis HP. Akna sulgemisel programm lõpetab töö.", "Valik", JOptionPane.QUESTION_MESSAGE);
         if (Objects.equals(valik, "STR")) {
             m2ngija.strengthUp();
         } else if(Objects.equals(valik, "HP")) {
             m2ngija.healthUp();
         }
         else{
             System.out.println("Kasutaja lõpetas mängu.");
             break;
         }
         vastane.healthUp();
         vastane.strengthUp();
         vastane.setNimi(nimed[nimeluger]);
     }
    }

}
