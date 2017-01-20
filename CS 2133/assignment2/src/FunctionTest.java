
public class FunctionTest {


    public static double findRoot(double a, double b, double epsilon) {


        double x = (a + b) / 2;

        if (Math.abs(a - x) < epsilon) {
            return x;
        }
        else if (Math.sin(x) >= 1 && Math.sin(a) >= 1 || Math.sin(x) < 0 && Math.sin(a) < 0) {
            return findRoot(x, b, epsilon);
        }
        else if (Math.sin(x) >= 1 && Math.sin(b) >= 1 || Math.sin(x) < 0 && Math.sin(b) < 0) {
            return findRoot(a, x, epsilon);
        }
        return x;
    }

    public static void main(String[] args) {

        //double epsilon = 0.0000001;
        FunctionTest.findRoot(3, 4, 0.0000001);
        System.out.println(Math.sqrt(findRoot(3, 4, 0.0000001)));


    }
}
            //Compute x, where x is halfway between a and b, iex=(a+b)/2
            //if |a-x| < e return n
            //if f(x) has the same sign as f(a), the root lies between x and b. Recursively perform the algorithm with
            //x as the new a
            //Otherwise, the root lies between a and x. Recursively preform the algorithm with x as the new b
