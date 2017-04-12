import java.io.*;
import java.util.Scanner;

public class MIPSSimulator {

    static int main_Memory[] = new int[1048576];
    static int general_Purpose_Registers[] = new int[32];
    static int PC;
    static int nPC;
    static int Hi;
    static int Lo;

    private final int addInst = 0b000000000000000000000000100000;
    private final int addIInst = 0b00100000000000000000000000000000;
    private final int addIUInst = 0b00100100000000000000000000000000;
    private final int addUInst = 0b00000000000000000000000000100001;
    private final int andInst = 0b00000000000000000000000000100100;
    private final int andIInst = 0b00110000000000000000000000000000;
    private final int begInst = 0b00010000000000000000000000000000;
    private final int bgezInst = 0b00000100000000010000000000000000;
    private final int bgezalInst = 0b00000100000100010000000000000000;
    private final int bgtzInst = 0b00011100000000000000000000000000;
    private final int blezInst = 0b00011000000000000000000000000000;
    private final int bltzalInst = 0b00000100000100000000000000000000;
    private final int bneInst = 0b00010100000000000000000000000000;
    private final int divInst = 0b00000000000000000000000000011010;
    private final int jumpInst = 0b00001000000000000000000000000000;
    private final int jalInst = 0b00001100000000000000000000000000;
    private final int jrInst = 0b00000000000000000000000000001000;
    private final int lbInst = 0b10000000000000000000000000000000;
    private final int luiInst = 0b00111100000000000000000000000000;
    private final int lwInst = 0b10001100000000000000000000000000;
    private final int mfhiInst = 0b00000000000000000000000000010000;
    private final int mfloInst = 0b00000000000000000000000000001000;
    private final int multInst = 0b00000000000000000000000000011000;
    private final int multuInst = 0b00000000000000000000000000011001;
    private final int noopInst = 0b00000000000000000000000000000000;
    private final int orInst = 0b00000000000000000000000000100101;
    private final int oriInst = 0b00110100000000000000000000000000;
    private final int sbInst = 0b10100000000000000000000000000000;
    private final int sllInst = 0b00000000000000000000000000000000;
    private final int sllvInst = 0b00000000000000000000000000000100;
    private final int sltInst = 0b00000000000000000000000000101010;
    private final int sltiInst = 0b00101000000000000000000000000000;
    private final int sltiuInst = 0b00101100000000000000000000000000;
    private final int sltuInst = 0b00000000000000000000000000101011;
    private final int sraInst = 0b00000000000000000000000000000010;
    private final int srlInst = 0b00000000000000000000000000000010;
    private final int srlvInst = 0b00000000000000000000000000000110;
    private final int subInst = 0b00000000000000000000000000100010;
    private final int subuInst = 0b00000000000000000000000000100011;
    private final int swInst = 0b10101100000000000000000000000000;
    private final int syscallInst = 0b00000000000000000000000000001100;
    private final int xorInst = 0b00000000000000000000000000100110;
    private final int xoriInst = 0b00111000000000000000000000000000;

    public static void main(String[] args) {

        // Loads the file that will be selected by the user into a scanner
        try {
            Scanner user_in = new Scanner(new File("hello.txt"));

            //checks the file for lines that don't start with [ and skips them
            while (user_in.hasNext()) {
                String currentLine = user_in.nextLine();
                String splitString[] = currentLine.split("\\s");

                for(String strings : splitString)
                {
                    if(strings.equals("")){continue;}
                    if (strings.startsWith("[") ) {
                        //Do stuff for start of line
                        strings = strings.substring(1, strings.length() - 1); // Remove brackets
                        if (strings.startsWith("P")) {
                            // Do PC code
                            System.out.println("Reached PC block, String is: " + strings);

                        } else if (strings.startsWith("R")) {
                            // Do R code

                            System.out.println("Reached R block, String is: " + strings);

                        } else
                        // Its a Hex address
                        {
                            System.out.println("We're a hex address inside brackets, String is: " + strings);
                        }
                    }
                    else if ( strings.startsWith("0x"))
                    {
                        System.out.print(" Our instruction is: " + strings + "\n");
                    }
                    else {
                        break; // the string isn't valid
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }


    }
    static void advance_pc (int offset)
    {
        PC  =  nPC;
        nPC  += offset;
    }
}
