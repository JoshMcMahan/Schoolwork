
public class Poly {
    public int coefficients[];

    public Poly(int[] coefficients){
        this.coefficients = coefficients;


    }
    public int degree(){
        return this.coefficients.length - 1;

    }
    public String toString(){
        String polyString = "";

        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] == 0)
                continue;
            if (i > 0)
                polyString += coefficients[i] + "x^" + i + "+";
            if ( i == 0)
                polyString += coefficients[i];
        }

        return polyString + " It worked!";
    }
 /**   public Poly add(Poly a){

    }*/

    public double evaluate(double x){
        double polyAnswer = 0;

        for(int i = 0; i < this.coefficients.length; i++){
            polyAnswer = polyAnswer + coefficients[i] * Math.pow(x, i);
        }
        return polyAnswer;
    }
    public static void main(String[] args){
        int polyTest[] = {4, 0, -8, 0, 3, 2};
        Poly myPoly = new Poly(polyTest);
        System.out.println(myPoly.toString());
        System.out.println(myPoly.evaluate(2.0));

    }


}
