package ua.ithillel.homework.lesson28;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.homework.lesson28.data.access.service.DataSourceConfiguration;
import ua.ithillel.homework.lesson28.data.access.dao.ProductDao;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        applicationContext.getBean(ProductDao.class);
    }
}
