package week1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 187z on 4/25/2016.
 */
public class User {
    private String username;
    private String password;
    private String email;
    private String name;

    private ArrayList<BlogPost> myPosts;

    public User(String uNm, String pw, String em, String nm){
        username = uNm;
        password = pw;
        email = em;
        name = nm;
        this.myPosts = new ArrayList<BlogPost>();
    }

    public String getUsername(){
        return username.toString();
    }

    public boolean checkPassword(String pw) {
        return pw.equals(password);
    }

    public String getName(){
        return name.toString();
    }

    public String getEmail(){
        return email.toString();
    }

    public void addBlogPost(BlogPost bp){
            myPosts.add(bp);
    }

    public List<BlogPost> getMyPosts(){
        return Collections.unmodifiableList(myPosts);
    }

}
