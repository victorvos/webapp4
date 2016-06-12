package week1.opdracht5;

/**
 * Created by 187z on 4/18/2016.
 */
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(4711, 100);

        while (true) {
            Socket s = ss.accept();
            MyServlet ms = new MyServlet(ss);
            ms.start();
        }

    }
}