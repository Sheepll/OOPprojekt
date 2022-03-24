package OOPprojekt;

import javax.swing.JOptionPane;

public class Alg {

    public static void main(String[] args) throws InterruptedException {
        String[] nimed = new String[]{"Lohe1","Lohe2"};
        String karakteriNimi = JOptionPane.showInputDialog(null, "Sisestage oma karakteri nimi", "Nimi", JOptionPane.QUESTION_MESSAGE);
        Karakter test = new Karakter(karakteriNimi,50,1.5);
        Vastane test2 = new Vastane(nimed[0],40,1.2);
        M2ng katse = new M2ng(test,test2,nimed);
        katse.action();


    }
}

