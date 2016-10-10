
public class PolyFunc extends Function{

        public int coefficients[];

        public PolyFunc(int[] coefficients){
            this.coefficients = coefficients;


        }
        public int degree(){
            return this.coefficients.length - 1;

            /**
             * Returns the power of the highest term that is not equal to zero
             */

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
            /**
             * Overrides the toString method and returns a string representing the polynomial
             */
        }
        /**   public Poly add(Poly a){
         *  Should have been used to add 2 polys together and create a third poly with the sum of poly1 and poly2

         }*/

        public double evaluate(double x){
            double polyAnswer = 0;

            for(int i = 0; i < this.coefficients.length; i++){
                polyAnswer = polyAnswer + coefficients[i] * Math.pow(x, i);
            }
            return polyAnswer;

            /**
             * Allows us to replaces the x term with a number to get the value of the polynomial
             */
        }
    public static void main(String[] args){
            int polyTest[] = {4, 0, -8, 0, 3, 2};
            PolyFunc myPoly = new PolyFunc(polyTest);
            System.out.println(myPoly.toString());
            System.out.println(myPoly.evaluate(2.0));

        }


    }

