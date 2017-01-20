import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Iterator;

public class Huffman {

    static class encode{

        static String stringToEncode;
        static String tree;

    }

     static class bigBadHuff{


        static PriorityQueue myQue;
        static HashMap<Character, String> map;
        static HashMap<Character, Integer> hash;

        encode myencode(String myString){
            myQue.clear();
            map.clear();
            hash.clear();

            encode retrunObject;
            newHash(myString);
            for(//TODO){
                    myQue.add(new treeNode(//finish before turning in));
        }
        while (bigBadHuff.myQue.size() > 2)
                bigBadHuff.myQue.add(new treeNode(myQue.remove(), myQue.remove()));
     }


    }



    static void newHash(String myString){

        for(int i = 0; i < myString.length(); i++){

        }
    }
    void encodingString(String in, String stringToEncode){

        for(int i = 0; i < in.length(); i++){
            encode.stringToEncode += bigBadHuff.map.
        }
    }

    void newMap(treeNode object, String maps){

        if( object == null) {
            return;
        }
        bigBadHuff.map.put(object.bitValue, maps);

        newMap(object.right, maps + "1");
        newMap(object.left, maps + "0");
    }

    void tree(treeNode object, String myString){

        if (object == null){
            myString = myString + "/";
        } else {
            myString = myString + object.bitValue;
            tree(object.right, myString);
            tree(object.left, myString);

        }

    }
}}