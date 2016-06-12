package week1.utils;

import week1.model.*;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;


/**
 * Created by 187z on 5/15/2016.
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        BlogService bs = ServiceProvider.getBlogService();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
