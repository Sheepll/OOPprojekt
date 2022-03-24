package OOPprojekt;

import javax.swing.JOptionPane;
public class Alg {
    public static void main(String[] args) {
        System.out.println("Olete sattunud lohede võitlusele, et alustada valige oma lohe nimi.");

        String karakteriNimi = JOptionPane.showInputDialog(null, "Sisestage oma karakteri nimi","Lohe nimi",JOptionPane.QUESTION_MESSAGE);
        System.out.println(karakteriNimi);
        //test
    }
}

