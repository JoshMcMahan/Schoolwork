

public class FibTest {


        public static int fibIter(int n){

            int fib1 = 1;
            int fib2 = 0;
            int currentFib = 0;

            for(int i = 1; i < n; i++)
            {
                currentFib = fib1 + fib2;
                fib2 = fib1;
                fib1 = currentFib;
            }
           return currentFib;
        }
        public static int fibRecur(int n){

           if(n == 0){
               return 0;
           }
           else if(n == 1 || n == 2) {
               return 1;
           }
           else{
               return (fibRecur(n - 1) + fibRecur(n - 2));
           }


        }
    public static void main(String[] args){

        //Test with iteration
        FibTest.fibIter(10);
        System.out.println("Fib with iteration is: " + fibIter(10));
        FibTest.fibIter(14);
        System.out.println("Fib with iteration is: " + fibIter(14));

        //Test with recursion
        FibTest.fibRecur(10);
        System.out.println("Fib with recursion is: " + fibRecur(10));
        FibTest.fibRecur(14);
        System.out.println("Fib with recursion is: " + fibRecur(14) + "\n");


        //Test timing recursion and iteration
        long time1 = System.currentTimeMillis();
        FibTest.fibRecur(40);
        System.out.println("Fib with recursion is: " + fibRecur(40) + " Running time: " + time1 + " milliseconds.");

        long time2 = System.currentTimeMillis();
        FibTest.fibIter(40);
        System.out.println("Fib with iteration is: " + fibIter(40) + " Running time: " + time2 + " milliseconds.");
        long time3 = time2 - time1;
        System.out.println("\nThere is a: " + time3 + " millisecond difference.");
    }
}


