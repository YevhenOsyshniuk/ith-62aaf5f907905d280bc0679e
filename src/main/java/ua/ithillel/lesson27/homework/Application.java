package ua.ithillel.lesson27.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson27.homework.service.CartService;
import ua.ithillel.lesson27.homework.service.ProductRepository;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ua.ithillel.lesson27.homework.service");
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        CartService cart = applicationContext.getBean(CartService.class);
    }
}
