import java.util.*;
import java.io.*;


public class Caesar {

    private Scanner myFile;


    public static void main(String[] arg) {

        openFile();



        System.out.println(cipher('A', 3));

    }

    public static char cipher(char myCipher, int myKey) {


        if (myCipher < 32 || myCipher > 126)
            return myCipher;
        else
            myCipher += (char) (myKey);

        if(myCipher > 126){
            myCipher -= 95;
            return myCipher;}
        else if(myCipher < 32){
            myCipher += 95;
            return myCipher;}
        else
            return myCipher;


    }
    public static void openFile(){
        try{
            Scanner myFile = new Scanner(new File("CaesarCipher.txt"));
            System.out.println("File opened");
        }
        catch (Exception e){
            System.out.println("File not found ");
            e.printStackTrace();
        }
    }
    public void readFile(){
        File myFile = new File("CaesarCipher.txt");
        String line;
        try{
            FileReader fr = new FileReader(myFile);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }

}

