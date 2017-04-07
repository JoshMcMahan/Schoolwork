import java.io.*;
import java.util.Scanner;

public class MIPSSimulator {

    static int main_Memory[] = new int[1048576];
    static int general_Purpose_Registers[] = new int[32];
    static int special_Purpose_Registers[] = new int[4];

    public static void main(String[] args) {

        // Loads the file that will be selected by the user into a scanner
        try {
            Scanner user_in = new Scanner(new File("hello.txt"));

            //checks the file for lines that don't start with [ and skips them
            while (user_in.hasNext()) {
                String currentLine = user_in.nextLine();
                if (currentLine.startsWith("[")) {
                    currentLine = currentLine.substring(1, currentLine.length());
                    if (currentLine.startsWith("P")) {
                        // Do PC code

                    } else if (currentLine.startsWith("R")) {
                        // Do R code
                    } else // Its a Hex address
                    {

                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }
}
