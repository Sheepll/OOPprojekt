package OOPprojekt;

import javax.swing.JOptionPane;
//Peaklass
public class Alg {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Teretulemast põrgusse , et alustada andke oma inimesele nimi.");
        String[] nimed = new String[]{"Rott","Rästikud","Metskass","Ahv","Ilves","Raisakotkas","Hundikari","Lõvi"};
        Thread.sleep(500);
        String karakteriNimi = JOptionPane.showInputDialog(null, "Sisestage oma karakteri nimi","Nimeta",JOptionPane.QUESTION_MESSAGE);
        Thread.sleep(500);
        System.out.println("Antud nimi: " + karakteriNimi);
        Thread.sleep(1000);
        System.out.println(karakteriNimi + " on ära eksinud tsivilisatsioonist kaugesse kohta. Aita tal sealt põgeneda" +
                "ja tagasi linna minna!");
        Thread.sleep(1000);

        Karakter m2ngija = new Karakter(karakteriNimi,30,1.0);
        Vastane loomake = new Vastane(nimed[0],10,0.8);
        M2ng test = new M2ng(m2ngija,loomake,nimed);
        test.action();
    }
}

