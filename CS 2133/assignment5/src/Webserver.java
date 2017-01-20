import java.net.ServerSocket;
import java.io.*;

    public class Webserver {

        public static void main(String[] args){

            int serverPort = 8080;
            try{
                ServerSocket ss = new ServerSocket(serverPort);
                while(true){
                    Thread conn = new Thread(new ClientConnection(ss.accept()));
                    conn.start();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

