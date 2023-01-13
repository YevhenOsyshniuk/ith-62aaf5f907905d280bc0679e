package ua.ithillel.homework.lesson28;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.homework.lesson28.data.access.dao.CartDaoImpl;
import ua.ithillel.homework.lesson28.data.access.DataSourceConfiguration;
import ua.ithillel.homework.lesson28.data.access.dao.ProductDaoImpl;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        System.out.println(applicationContext.getBean(CartDaoImpl.class));
        System.out.println(applicationContext.getBean(ProductDaoImpl.class));
    }
}
