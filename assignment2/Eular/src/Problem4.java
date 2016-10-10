
public class Problem4 {

    public static void main(String[] args) {
        String num4 = "";
        for (int i = 100; i < 999; i++) {
            for (int j = 100; j < 999; j++) {
                int num3 = i * j;
                num4 = Integer.toString(num3);
                String numRev = new StringBuffer(num4).reverse().toString();
                if (num4.equals(numRev)) {

                } //Not working come back and fix
            }
        }
        System.out.println(num4);
    }
}


