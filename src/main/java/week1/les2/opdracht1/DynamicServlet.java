package week1.les2.opdracht1;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gh0st on 19/04/16.
 */

public class DynamicServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("username");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        out.println(" <h2>Hello " + name + "!</h2>");
    }
}