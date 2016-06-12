/**
 * Created by 187z on 4/18/2016.
 */

package week1.opdracht4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(4711);

        Socket s = ss.accept();

        MyServlet ms = new MyServlet(ss);
        ms.start();

    }
}