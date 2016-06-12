package week1.les2.opdracht1; /**
 * Created by gh0st on 14/04/16.
 */

import week1.model.BlogService;
import week1.model.ServiceProvider;
import week1.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.lang.System.out;

public class RegisterServlet extends HttpServlet {
    private ArrayList<User> users;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String passwd = req.getParameter("password");
        String passwdverify = req.getParameter("password-verify");
        String realname = req.getParameter("realname");
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        RequestDispatcher rd = null;
        BlogService bs = ServiceProvider.getBlogService();

        boolean isRegistered = bs.registerUser(username, passwd, email, realname);

        if (passwd.equals(passwdverify) && isRegistered) {
            req.setAttribute("msgs", "You've succesfully registered!");
            req.setAttribute("client", "Your username is: " + username + "<br />" + "Your password is: " + passwd + "<br />" + "Your email address is: " + email);
            rd = req.getRequestDispatcher("/blog/index.jsp");
//            resp.sendRedirect("/blog/index.jsp");

//            users.add(new User(username, passwd, email, realname));

        } else {
            req.setAttribute("msgs", "Username and/or password are incorrect!");
            rd = req.getRequestDispatcher("/blog/index.jsp");
//            resp.sendRedirect("error.html");
        }

        rd.forward(req, resp);


    }

    public void init()  throws ServletException{
//        ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("registeredUsers");
        BlogService bs = ServiceProvider.getBlogService();
        users = bs.getAllUsers();
    }
}
