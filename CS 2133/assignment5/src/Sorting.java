import java.util.Arrays;
import java.util.Random;

public class Sorting {

    public static long bubbleTimerStart = 0;
    public static long bubbleTimerStop = 0;
    public static long finalBubbleTime = 0;

    public static long mergTimerStart = 0;
    public static long mergTimerStop = 0;
    public static long finalMergTime = 0;

    public static long seconds = 20000;

    static double[] a1;
    static double[] a2;

    public static void main(String[] args) {

        int n = 1;
        while (true) {

            n = createArray(n);

            bubbleTimerStart = System.currentTimeMillis();
            bubbleSort(a1);
            bubbleTimerStop = System.currentTimeMillis();
            finalBubbleTime = -bubbleTimerStart + bubbleTimerStop ;

            System.out.println(" bubble sort ran for " + finalBubbleTime + " milliseconds!! ");


            mergTimerStart = System.currentTimeMillis();
            mergSort(a2);
            mergTimerStop = System.currentTimeMillis();
            finalMergTime = -mergTimerStart + mergTimerStop;
            System.out.println(" merg sort ran for " + finalMergTime + " milliseconds!! ");
        }
    }

    public static int createArray(int n) {

        int size = n;
        size *= 10;

        a1 = new double[n];

        Random ran = new Random();
        for (int i = 0; i < a1.length; i++) {
            a1[i] = ran.nextDouble();
        }
        a2 = Arrays.copyOf(a1, a1.length);

        //System.out.println(n);
        return size;

    }

    public static double[] bubbleSort(double[] a1) {

        double bubbleArray;
        bubbleTimerStart = System.currentTimeMillis();


        for (int i = 0; i < a1.length - 1; i++) {
            bubbleTimerStop = System.currentTimeMillis();
            if (bubbleTimerStart + seconds < bubbleTimerStop) {
                System.out.println("bubblesort ran over the allotted time!!! ");
                System.exit(0);
            }
                for (int j = 0; j < (a1.length - 1 - i); j++) {
                    if (a1[j] > a1[j + 1]) {
                        bubbleArray = a1[j];
                        a1[j] = a1[j + 1];
                        a1[j + 1] = bubbleArray;
                    }
                }
            }
            return a1;
        }

        public static double[] mergSort ( double[] a2){


            double[] mergArray = null;
            if (mergTimerStart + seconds < mergTimerStop) {
                System.out.println(" mergsort ran over the allotted time!!! ");
                System.exit(0);
            }

            if (a2.length <= 1) {
                return a2;
            }

            int a2Half = a2.length / 2;

            double[] leftMerg = new double[a2Half];
            double[] rightMerg = new double[a2.length - a2Half];

            System.arraycopy(a2, 0, leftMerg, 0, a2Half);
            System.arraycopy(a2, a2Half, rightMerg, 0, (a2.length - a2Half));

            leftMerg = mergSort(leftMerg);
            rightMerg = mergSort(rightMerg);

            mergArray = merg(leftMerg, rightMerg);

            //System.out.println("merg " + Arrays.toString(a2));

            return mergArray;
        }

        public static double[] merg ( double[] first, double[] second){

            double[] finalMerg = new double[first.length + second.length];

            int mergLeft = 0;
            int mergRight = 0;

            for (int i = 0; i < finalMerg.length; i++) {
                if (mergRight >= second.length || (mergLeft < first.length && first[mergLeft] <= second[mergRight])) {
                    finalMerg[i] = first[mergLeft];
                    mergLeft++;
                } else {
                    finalMerg[i] = second[mergRight];
                    mergRight++;
                }
            }

            return finalMerg;
        }
    }

    // After running both bubblesort ( O(n^2)) and mergesort ( O(n log n) the mergesort runs a lot faster
    // The thing that I think makes bubblesort so much slower is the fact that it grows complex very fast
    // mergesort is the opposite as it grows slower than bubblesort