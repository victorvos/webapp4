package week1.les2.opdracht1;

import week1.model.BlogService;
import week1.model.ServiceProvider;
import week1.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 187z on 5/16/2016.
 */
public class BlogPostServlet extends HttpServlet {
    private ArrayList<User> users;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String blogSubject = req.getParameter("blogsubject");
        String blogPost = req.getParameter("blogpost");


        RequestDispatcher rd = null;
        BlogService bs = ServiceProvider.getBlogService();
        User person = (User)req.getSession().getAttribute("loggedUser");

        bs.addBlogPostForUser(blogSubject, blogPost, person);
        rd = req.getRequestDispatcher("/blog/blogger/myposts.jsp");



        rd.forward(req, resp);


    }

    public void init()  throws ServletException{
        BlogService bs = ServiceProvider.getBlogService();
        users = bs.getAllUsers();
    }
}


