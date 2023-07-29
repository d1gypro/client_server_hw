import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final Integer PORT = 80;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is ready!");

            while (true) {
                try (Socket client = serverSocket.accept();
                     PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))
                ){
                    pw.println("Write your name");
                    String nameClient;
                    nameClient = br.readLine().substring(0,3);
                    if (!nameClient.isEmpty()) {
                        System.out.println("Client name is: " + nameClient);
                        pw.println("Are you child? (yes/no)");
                    }
                    if (br.readLine().equals("yes")) {
                        pw.printf("Welcome to the kids area, %s! Let's play!", nameClient);
                    } else {
                        pw.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", nameClient);
                    }




                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
