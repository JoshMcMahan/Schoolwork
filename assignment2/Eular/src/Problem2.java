
public class Problem2 {
    public static void main(String[] args){
        //int userArg = Integer.parseInt(args[0]);


        int fib1 = 1;
        int fib2 = 2;
        int currentFib = 0;

        while (fib1 <= 4000000) {
            if (fib1 % 2 == 0)
                currentFib += fib1;
            int fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
        }
        System.out.println("Fib is: " + currentFib);
    }
}
