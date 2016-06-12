package week1.opdracht4;
/**
 * Created by gh0st on 13/04/16.
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServlet extends Thread {
    private ServerSocket socket;

    public MyServlet(ServerSocket ss) {
        socket = ss;
    }

    public void run() {
        Socket s;
        try {
            s = socket.accept();
            Scanner scanner = new Scanner(s.getInputStream());

            String line = scanner.nextLine();
            while(!line.equals("") && line != null && !line.equals(" ")) {
                System.out.println(line);
                line = scanner.nextLine();
            }

            System.out.println("SUCCES");
            scanner.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}