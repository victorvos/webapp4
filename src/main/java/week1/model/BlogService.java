package week1.model;

import sun.invoke.empty.Empty;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 187z on 5/11/2016.
 */
public class BlogService extends HttpServlet  {

    private ArrayList<User> allUsers = new ArrayList<User>();

    public void addBlogPostForUser(String sub, String txt, User u) throws IllegalArgumentException {
        if(sub != null || txt != null || sub.equals("") || txt.equals("")){
            BlogPost bp = new BlogPost(sub, txt);
            u.addBlogPost(bp);
        }

    }
    public boolean registerUser(String uNm, String pw, String em, String rN){
        boolean alreadyExist = false;
        if (!allUsers.isEmpty()){
            for(User u : allUsers ){
                if( u.getUsername().equals(uNm) ){
                    alreadyExist = true;
                }

            }
        }


        if(!alreadyExist){
            allUsers.add(new User(uNm, pw, em, rN));
            return true;}

        return false;
    }

    public User loginUser(String uNm, String pw){
        for(User u : allUsers ){
            if(u.checkPassword(pw) && u.getUsername().equals(uNm) ){
                return u;
            }

        }
        return null;
    }

    public ArrayList<User> getAllUsers(){
        return allUsers;
    }

    public ArrayList<BlogPost> getAllPosts(){
        ArrayList<BlogPost> allPosts = new ArrayList<BlogPost>();

        for(User user : allUsers ){
            allPosts.addAll(user.getMyPosts());
        }

        return allPosts;

    }


//     public void init() throws ServletException {
//        ArrayList<User> allUsers = new ArrayList<User>();
//
//
////        ServletContext context = getServletContext();
////        User u1 = new User("Quinten", "123", "buinten@google.com", "Quinten");
////        User u2 = new User("Bob", "123", "bob@google.com", "Bob");
////
////        userList.add(u1);
////        userList.add(u2);
////        context.setAttribute("registeredUsers", userList);
//    }

}
