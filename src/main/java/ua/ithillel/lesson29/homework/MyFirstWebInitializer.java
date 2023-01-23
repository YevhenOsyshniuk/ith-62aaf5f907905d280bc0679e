package ua.ithillel.lesson29.homework;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyFirstWebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
         var rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebApplicationConfig.class);

        container.addListener(new ContextLoaderListener(rootContext));

        var dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
