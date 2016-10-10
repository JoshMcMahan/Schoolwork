import java.lang.*;
import java.util.Scanner;

public class Ramanujan extends Factorial {
    public static void main(String[] args){

        Scanner scanInput = new Scanner(System.in);
        System.out.println("Enter a integer. ");
        int userInput = scanInput.nextInt();
        double ramanuPi = 0;
        int k = 0;

        for (int i = 0; i < userInput; i++){
            ramanuPi = ramanuPi + Factorial.calculate(4 * k) * (1103 + 26390 * k) / Math.pow(Factorial.calculate(k),4) * Math.pow(396,4 * k);
            k++;
        }
        System.out.println("Pi according to Ramanujan's series is: " + ramanuPi);
        System.out.println("This is " + (ramanuPi / Math.PI * 100) + "% accurate.");

    }

}     //ramanuPi = ramanuPi + Math.pow(4,k+1) * 4.0 / (2.0 * k - 1);


