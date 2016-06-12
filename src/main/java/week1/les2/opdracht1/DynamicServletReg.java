package week1.les2.opdracht1; /**
 * Created by gh0st on 14/04/16.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DynamicServletReg extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

            String passwd = req.getParameter("password");
            String passwdverify = req.getParameter("password-verify");
            String realname = req.getParameter("realname");
            String username = req.getParameter("username");

            if(passwd.equals(passwdverify.toString())) {


                PrintWriter out = resp.getWriter();
                resp.setContentType("text/html");

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Dynamic Example</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h2>Register succesful!</h2>");
                out.println(" <h2>Hello " + realname + ", thank you for registering!.</h2>");

                out.println(" </body>");
                out.println("</html>");
            }
        else{

                PrintWriter out = resp.getWriter();
                resp.setContentType("text/html");

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Dynamic Example</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h2>Error registering!</h2>");
                out.println(" <h2>Passwords don't match!.</h2>");
                out.println(" </body>");
                out.println("</html>");

            }

    }



}
