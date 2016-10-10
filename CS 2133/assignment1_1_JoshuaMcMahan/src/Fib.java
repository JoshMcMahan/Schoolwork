
public class Fib {
    public static void main(String[] args){
        int userArg = Integer.parseInt(args[0]);

        int fib1 = 1;
        int fib2 = 0;
        int currentFib = 0;

        for(int i = 1; i < userArg; i++)
        {
            currentFib = fib1 + fib2;
            fib2 = fib1;
            fib1 = currentFib;
        }
        System.out.println("Fib is: " + currentFib);
    }
}
