import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("A poryt 421 is ready for the connection.");
        try {
            ServerSocket serversocket=new ServerSocket(421);
            Socket socket=serversocket.accept();
            System.out.println("client is connected");

            //asking for input from the user
            BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));

            //atking input from the socket
            BufferedReader socketInput=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //to send a message i need a pen
            OutputStream outputStream=socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(outputStream);

            String sendingMessage,receivingMessage;
            while(true){
                sendingMessage=userInput.readLine();
                printWriter.println(sendingMessage);
                printWriter.flush();
                receivingMessage=socketInput.readLine();
                System.out.println("client: " + receivingMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}