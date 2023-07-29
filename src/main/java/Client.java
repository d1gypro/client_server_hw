import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("netology.homework", Server.PORT);
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ){
 //           while (!socket.isOutputShutdown()) {
            String inputMessage = br.readLine();
            if (inputMessage.equals("Write your name")) {
                System.out.println("Server: " + inputMessage);
                pw.println("Neo. I'm follow to the white rabbit...");
                System.out.println("Sending message: Neo. I'm follow to the white rabbit...");
            }
            inputMessage = br.readLine();
            if (inputMessage.equals("Are you child? (yes/no)")) {
                System.out.println("Server: " + inputMessage);
                String[] answerChildOrNot = { "yes", "no"};
                String answerAge = answerChildOrNot[new Random().nextInt(answerChildOrNot.length)];
                pw.println(answerAge);
                System.out.println("Sending message: " + answerAge);
            }
            inputMessage = br.readLine();
            System.out.println("Server: " + inputMessage);


//            pw.println("Neo");
//            System.out.println("Server: " + br.readLine());
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
        }
    }
