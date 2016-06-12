package week1.opdracht6;

/**
 * Created by 187z on 4/18/2016.
 */
import java.io.*; import java.net.*; import java.util.*;

public class Server {
    public static void main(String[] args) throws IOException {
        final ArrayList<PrintWriter> allClients = new ArrayList<PrintWriter>();
        while (true) {
            try (ServerSocket ss = new ServerSocket(8080)) {
                final Socket s = ss.accept();
                new Thread() {
                    public void run() {
                        PrintWriter pw = null;
                        try (Scanner scanner = new Scanner(s.getInputStream())) {
                            allClients.add(pw = new PrintWriter(s.getOutputStream()));
                            while (scanner.hasNextLine()) {
                                String message = scanner.nextLine();
                                for (PrintWriter printer : allClients) {
                                    printer.println(message);
                                    printer.flush();
                                }
                            }
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        } finally { allClients.remove(pw); }
                    }
                }.start();
            }
        }
    }
}
