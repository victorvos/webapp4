package week1.opdracht3;

/**
 * Created by gh0st on 19/04/16.
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.util.Scanner;

class Server {
    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(4710);
        System.out.println("start");
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        Scanner scan = new Scanner(is);
        while(scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        s.close();
        scan.close();
        ss.close();
    }
}