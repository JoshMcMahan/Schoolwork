

public class Problem3 {
    public static void main(String[] args) {
        long euler = 600851475143L;
        System.out.println(eulerPrime(euler));
    }

    public static long eulerPrime(long euler) {
        int i;
        for (i = 1; i < euler; i++) {
            if (euler % i == 0) {
                euler /= i;
            }
        }
        return euler;
    }

}



