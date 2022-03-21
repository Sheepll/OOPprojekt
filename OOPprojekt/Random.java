package OOPprojekt;
import java.lang.Math;

public class Random {
    public double Damage(){
        int min = 1;
        int max = 10;
        return (int)(Math.random() * (max - min + 1) + min);
    }
}//klass
