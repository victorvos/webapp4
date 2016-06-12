package week1.model;

/**
 * Created by 187z on 5/11/2016.
 */
public class BlogPost {
    private long creationTime;
    private String subject;
    private String text;

    public BlogPost (String sub, String txt){
        subject = sub;
        text = txt;
        creationTime = System.currentTimeMillis() % 1000;
    }

    public long getCreationTime(){
        return creationTime;
    }

    public String getText(){
        return text;
    }

    public String getSubject(){
        return subject;
    }

}
