import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class KirjutaLogi {
    static {create();}
    private String tekst;

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
