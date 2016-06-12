package week1.opdracht3;

/**
 * Created by gh0st on 19/04/16.
 */
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Client {
    public static void main(String[] arg) throws Exception {
        Socket s = new Socket("localhost", 4710);

        OutputStream os = s.getOutputStream();
        PrintWriter pw = new PrintWriter(os);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String invoer = scanner.nextLine();

            if (invoer.equals("stop")) {
                pw.println("-- verbinding verbroken --");
                System.out.println("-- verbinding gestopt --");
                pw.flush();
                break;
            } else {
                pw.println(invoer);
                pw.flush();
            }
        }

        scanner.close();
        s.close();
    }
}