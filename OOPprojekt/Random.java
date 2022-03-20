package OOPprojekt;
import java.lang.Math;

public class Random {
    public static void main(String[] args){
        int min = 1;
        int max = 10;
        int juhuslikNUmber = (int)(Math.random() * (max - min + 1) + min);
        System.out.println("Suvaline nr: " + juhuslikNUmber);
    }
}//klass
