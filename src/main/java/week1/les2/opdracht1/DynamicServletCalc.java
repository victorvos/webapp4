package week1.les2.opdracht1; /**
 * Created by gh0st on 14/04/16.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DynamicServletCalc extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

            String username = req.getParameter("username");
            int val1 = Integer.parseInt(req.getParameter("val1"));
            int val2 = Integer.parseInt(req.getParameter("val2"));
            String MathOp = req.getParameter("MathOp");

            int answ = 0;

            if (MathOp.equals("x")){
                answ = val1 * val2;
            }

            if (MathOp.equals("+")){
                answ = val1 + val2;
            }

            if (MathOp.equals(":")){
                answ = val1 / val2;
            }

            if (MathOp.equals("-")){
                answ = val1 - val2;
            }

        PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Dynamic Example</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h2>Calculator</h2>");
                out.println(" <h2>Hello " +username+ ", I've calculated the following for you:</h2>");
                out.println(" <h3>" + val1 + MathOp + val2 + "=" + answ + "</h3>");
                out.println(" </body>");
                out.println("</html>");
    }



}
