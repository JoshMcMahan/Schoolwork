import java.lang.*;

public class Gregory {
    public static void main(String[] args){
        int userInput = Integer.parseInt(args[0]);
        double gregsPi = 0.0;

        // -1 power of k-1, mulit 4 / 2k-1 + gregspi
        // power of (math.pow) first one -1 (k+1), multiply by 4, divide by 2k -1, K is counter in for loop
        // but what stops your for loop is the user input, int k equals 1 then thje middle part should be k less than user iunput,
        // k++ , the value from this needs to be put into a variable and.... gregs pie = gregs pie * gregs pie

        int k = 1;
        for (int i = 0; i < userInput; i++){
            gregsPi = gregsPi + Math.pow(-1,k+1) * 4.0 / (2.0 * k - 1) ;
            k++;
        }
        System.out.println("Pi according to Gregory series is: " + gregsPi);
        System.out.println("This is " + (gregsPi / Math.PI * 100) + "% accurate.");

        }

}
