import java.io.FileWriter;
import java.io.IOException;

public class KirjutaLogi {
    //static create() kindlustab, et iga mängu käivitamise puhul luuakse uus logifail
    //või kirjutatakse vana üle. Seega on alati olemas kõige rohkem üks logifail,
    //mis sisaldab infot kõige hiljutisema mängu kohta.
    static {create();}

    //Kirjutab antud failinimega faili teksti juurde, jättes eelneva sisu alles.
    public void sissekanne(String tekst){
        try{
            FileWriter fail = new FileWriter("logifail.txt",true);
            fail.write(tekst + "\n");
            fail.close();

        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
    }

    public static void create(){
        try{
            FileWriter fail = new FileWriter("logifail.txt",false);
            fail.write("Logifaili algus" + "\n");
            fail.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
