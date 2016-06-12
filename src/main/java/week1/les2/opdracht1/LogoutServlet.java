package week1.les2.opdracht1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 187z on 5/10/2016.
 */
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

            req.getSession().removeAttribute("loggedUser");
            resp.sendRedirect("/blog/index.jsp");
    }
}
