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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class LoginServlet extends HttpServlet {

        private ArrayList<User> users;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean loggedInSuccess = false;


        RequestDispatcher rd = req.getRequestDispatcher("/blog/blogger/myaccount.jsp");
        BlogService bs = ServiceProvider.getBlogService();

        // check if users not null or empty



        for(User u : users ){
            if(u.checkPassword(password) && u.getUsername().equals(username) ){
                loggedInSuccess = true;
                req.getSession().setAttribute("loggedUser", u);
                resp.addCookie(new Cookie("useername", u.getUsername()));
                // set session
            }
        }

        if(!loggedInSuccess) {
            req.setAttribute("error", 1);
            rd = req.getRequestDispatcher("error.html");
//            resp.sendRedirect("error.html");
        }

//        resp.sendRedirect("/blog/myaccount.jsp");
        rd.forward(req, resp);


    }

    public void init()  throws ServletException{
        BlogService bs = ServiceProvider.getBlogService();
        users = bs.getAllUsers();
    }
}
