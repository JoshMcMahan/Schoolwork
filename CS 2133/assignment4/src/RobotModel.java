import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RobotModel {
    private static final String rHttp = "lear.cs.okstate.edu";
    private static final int port = 9095;
    private static PrintWriter rw;

    public RobotModel(){

        try {
            Socket rs = new Socket(rHttp, port);
            rw = new PrintWriter(rs.getOutputStream());

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static PrintWriter getRS(){
        return rw;
    }


}
