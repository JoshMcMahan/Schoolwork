import java.util.*;
import java.io.*;


public class Caesar {

    // private Scanner myFile;
    private static BufferedReader br;
    private static FileReader fr;
    private static PrintWriter fw;
    File inFile;
    File outFile;
    int mykey;


    public static void main(String[] arg) {
        String line = readFile();
        String myCipher = cipher(line, 3);
        //cipher(line, 3);
        fw.write(myCipher);
        fw.flush();
        System.out.println(line);


    }


    public static String cipher(String toCipher, int myKey) {
        String myCipher = "";


        for (int i = 0; i < toCipher.length(); i++) {
            char tempChar = toCipher.charAt(i);
            if (tempChar > 32 || tempChar < 126);
            tempChar = (char) (tempChar + myKey);
            if (tempChar > 126) tempChar = (char) (tempChar - 95);
            if (tempChar < 32) tempChar = (char) (tempChar + 95);
            myCipher += tempChar;

        }
        return myCipher;
    }

    public static String readFile() {
        File inFile = new File("inFile.txt");
        File outFile = new File("outFile.txt");
        String duck = "";

        try {
            fr = new FileReader(inFile);
            br = new BufferedReader(fr);
            fw = new PrintWriter(outFile);
            System.out.println("This line reached 1");
            System.out.println(br);
            String line = "";
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                //fw.write(line);
                duck += line;

            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return duck;
    }

}


