import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        try {
            Socket socket=new Socket("127.0.0.1",421);

            //asking for input from the user
            BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));

            //atking input from the socket
            BufferedReader socketInput=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //to send a message i need a pen
            OutputStream outputStream=socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(outputStream);

            String sendingMessage,receivingMessage;
            while(true){
                receivingMessage=socketInput.readLine();
                System.out.println("Server: " + receivingMessage);
                sendingMessage=userInput.readLine();
                printWriter.println(sendingMessage);
                printWriter.flush();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
