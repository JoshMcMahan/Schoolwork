import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WebPanel extends JPanel {

    private JTextField urlText = new JTextField("Enter a URL ", 60);
    private JTextArea display = new JTextArea(38, 65);
    private JScrollPane scroll = new JScrollPane(display);
    private static final int port = 80;
    private static PrintWriter out;
    private static BufferedReader in;


    public WebPanel(WebFrame titleFrame){
        String allLines = WebModel();

        titleFrame.setTitle(allLines.substring(allLines.indexOf("<title>") + 7, allLines.indexOf("</title>")));

        urlText.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        getPage(e.getActionCommand());
                    }
                }
        );
        add(urlText);
        display.append(WebModel());
        add(scroll);







    }
    public void getPage(String urlInput){
        try{

            urlText.setText(urlInput);
            //System.out.println(urlInput);
        }
        catch (Exception e){
            System.out.println("No page found");
        }
    }
    public static String WebModel(){

        String line;
        String allLines= "";

        try {
            Socket socket = new Socket("cs.okstate.edu", port);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.print("GET / HTTP/1.1\r\n");
            out.print("host: cs.okstate.edu\r\n\r\n");
            out.flush();
            while((line=in.readLine()) !=null) {
                allLines += line + "\r\n";
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allLines;
    }

}

