package week1.model;

/**
 * Created by 187z on 5/12/2016.
 */
public class ServiceProvider {
    private static BlogService BlogService = new BlogService();

    public static BlogService getBlogService() {
        if(BlogService != null) {
            return BlogService;
        }
        return null;
    }
}
