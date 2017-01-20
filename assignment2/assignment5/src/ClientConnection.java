import java.io.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientConnection implements Runnable {

        private static final String INDEX_HTML = "index.html";
        private static final String TEST_JPG = "database.jpg";

        private final String HTTTP_RESPONSE_GOOD = "HTTP/1.1 200 OK\r\n";
        private final String HTTTP_RESPONSE_NOT_FOUND = "HTTP/1.1 404 Not Found\r\n\r\n";
        private final String HTTTP_RESPONSE_INTERNAL_ERROR = "HTTP/1.1 500 Internal Server Error\r\n\r\n";

        private final String CONTENT_HTML = "Content-type: text/html\r\n\r\n";
        private final String CONTENT_JPG = "Content-type: image/jpg\r\n\r\n";

        private Socket socket;
        private BufferedWriter serverReader;
        private File inputFile;

        ClientConnection(Socket socket){
            this.socket = socket;
        }

        public void run() {
            String input = "";

            try {
                BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while ((input = serverReader.readLine()) != null){
                    if(input.startsWith("GET")){
                        break;
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
            }

            String fileName = fileNameRegex(input);
            String header = "";

            if(fileName != null){
                header = HTTTP_RESPONSE_GOOD;
            } else {
                header = HTTTP_RESPONSE_NOT_FOUND;
            }

            try {
                inputFile = new File(fileName);

                if(!inputFile.exists()){

                    header = HTTTP_RESPONSE_NOT_FOUND;
                    serverReader = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    if(new File("404.html").exists()){
                        serveNotFound();
                    } else {
                        serverReader.write(header);
                        serverReader.flush();
                        serverReader.close();
                    }
                    return;
                } else {
                    serverReader = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    serverReader.write(HTTTP_RESPONSE_INTERNAL_ERROR);
                }
            } catch (IOException e){
                System.out.println("IOException");
            }

            try {
                if(header.equals(HTTTP_RESPONSE_GOOD)){
                    if(fileName.endsWith(".jpg")){
                        serverReader.write(CONTENT_JPG);
                        inputFile = new File(fileName);
                        FileInputStream imageReader = new FileInputStream(inputFile);
                        byte[] byteArray = new byte[(int)inputFile.length()];
                        imageReader.read(byteArray);
                        String output = new String(byteArray, "UTF-8");
                        serverReader.write(output);
                        serverReader.flush();
                        serverReader.close();
                    } else {
                        //doesn't work with the content type response for some reason
                        //serverReader.write(CONTENT_HTML);
                        inputFile = new File(fileName);
                        FileInputStream fileReader = new FileInputStream(inputFile);
                        byte[] byteArray = new byte[(int)inputFile.length()];
                        fileReader.read(byteArray);
                        String output = new String(byteArray, "UTF-8");
                        serverReader.write(output);
                        serverReader.flush();
                        serverReader.close();
                    }
                } else {

                }
            } catch (IOException e){
                System.out.println("IOException in run()");
            }
        }

        public void serveNotFound(){
            try {
                BufferedReader serverReaderNotFound = new BufferedReader(new FileReader(new File("404.html")));
                String output = "";
                String line = "";

                while ((line = serverReaderNotFound.readLine()) != null){
                    output += line;
                }

                if(serverReader != null){
                    serverReader.write(HTTTP_RESPONSE_GOOD);
                    serverReader.write(CONTENT_HTML);
                    serverReader.write(output);
                    serverReader.flush();
                    serverReader.close();
                }
            } catch (FileNotFoundException e){
                System.out.println("404 page not found, lol");
            } catch (IOException e){
                System.out.println("IOException in serveNotFound");
            }
        }

        public String fileNameRegex(String input) {

            String file = "";

            if(input == null){
                return INDEX_HTML;
            }

            Matcher matcher = Pattern.compile("GET\\s\\/(.*?)\\sHTTP\\/1\\.1", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(input);
            try {
                while (matcher.find()){
                    file = matcher.group(1);
                }
            } catch (Exception e){
                System.out.println("No file found in request");
                return null;
            }

            if(file.equals("/") || file.equals("") || file == null) {
                return INDEX_HTML;
            } else {
                return file;
            }
        }
    }