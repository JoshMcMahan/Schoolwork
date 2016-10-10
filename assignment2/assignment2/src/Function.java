
public abstract class Function {


    public abstract double evaluate(double x);


    public double findRoot(double a, double b, double epsilon) {


        double x = (a + b) / 2;

        if (Math.abs(a - x) < epsilon) {
            return x;
        }
        else if (evaluate(x) >= 1 && evaluate(a) >= 1 || evaluate(x) < 0 && evaluate(a) < 0) {
            return findRoot(x, b, epsilon);
        }
        else if (evaluate(x) >= 1 && evaluate(b) >= 1 || evaluate(x) < 0 && evaluate(b) < 0) {
            return findRoot(a, x, epsilon);
        }
        return x; // Refactored version of findRoot that uses evaluate. This allows use to find sin(x) and cos(x)
    }
    public static void main(String[] args){
        SinFunc sin = new SinFunc();
        System.out.println("The root of sin(x) between 3 and 4\n" + sin.findRoot(3, 4, 0.0000001));
        CosFunc cos = new CosFunc();
        System.out.println("The root of cos(x) between 1 and 3 \n" + cos.findRoot(1, 3, 0.0000001));

        int polyFunc1[] = {-3, 0, 1};
        PolyFunc rootPoly1 = new PolyFunc(polyFunc1);
        System.out.println("The positive root of x^2-3\n" + rootPoly1.findRoot(0, 10, 0.0000001));

        int polyFunc2[] = {-2, -1, 1};
        PolyFunc rootPoly2 = new PolyFunc(polyFunc2);
        System.out.println("The positive root of x^2-1-2\n" + rootPoly2.findRoot(0, 10, 0.0000001));
    }
}
