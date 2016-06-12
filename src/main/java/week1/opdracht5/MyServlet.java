package week1.opdracht5;

/**
 * Created by 187z on 4/18/2016.
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
            Thread.sleep(1000);
            Scanner scanner = new Scanner(s.getInputStream());
            String line = scanner.nextLine();
            while(line != null && !line.equals("") && !line.equals(" ")) {
                System.out.println(line);
                line = scanner.nextLine();
            }
            scanner.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}