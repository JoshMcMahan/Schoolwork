public class Caesar {
    public static void main(String[] arg){
        System.out.println(cipher('A', 3));

    }
    public static char cipher(char myCipher, int myKey){


        if(myCipher < 32 || myCipher > 126)
            return myCipher;
        else
            myCipher += (char)(myKey);
            return myCipher;
        if(myCipher > 126)
            myCipher -= 95;
        return myCipher;
        else if (myCipher < 32) {
            myCipher += 95;
            return myCipher;
        }

    }
}

