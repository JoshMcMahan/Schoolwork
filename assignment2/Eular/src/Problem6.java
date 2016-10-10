
public class Problem6 {
    public static void main(String[] args){
        int hundoNatural = 100;
        int nat1 = hundoNatural *(hundoNatural + 1) / 2;
        int nat2 = (hundoNatural * (hundoNatural + 1) * (2 * hundoNatural + 1)) / 6;
        //int nat3 = 0;



        System.out.println(nat1 * nat1 - nat2);
    }

}
