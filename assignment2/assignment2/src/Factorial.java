

public class Factorial {

    public static long calculate(long n){
        if (n < 0 || n > 20){
           System.out.println("Can not be < 0 or > 20 ");
            return 0;
        }
        if (n == 1 || n == 0){
            return 1;
        }
        else {
           return (n * calculate(n - 1 ));
        }
    }
    public static void main (String[] args){

        System.out.println();

        // Calls the calculate function
        if (Factorial.calculate(0) == 1)
            System.out.println("Factorial.calculate(0) resulted in 1, test passed!");
        else
            System.out.println("Test failed! Result was " + calculate(0));

        if (Factorial.calculate(3) == 6)
            System.out.println("Factorial.calculate(3) resulted in 6, test passed!");
        else
            System.out.println("Test failed! Result was " + calculate(3));

        if (Factorial.calculate(5) == 120)
            System.out.println("Factorial.calculate(5) resulted in 120, test passed!");
        else
            System.out.println("Test failed! Result was " + calculate(5));



    }




}
