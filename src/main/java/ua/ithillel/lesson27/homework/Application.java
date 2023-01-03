package ua.ithillel.lesson27.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson27.homework.entity.Product;
import ua.ithillel.lesson27.homework.service.CartService;
import ua.ithillel.lesson27.homework.service.ProductRepository;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ua.ithillel.lesson27.homework.service");
        Product product1 = new Product(1, "name 1", 10);
        Product product2 = new Product(2, "name 2", 20);
        Product product3 = new Product(3, "name 3", 30);
        ProductRepository productRepository = new ProductRepository();
        productRepository.add(product1);
        productRepository.add(product2);
        productRepository.add(product3);

        CartService cart = new CartService(productRepository);
        cart.addProduct(product1.getId());
        cart.addProduct(product2.getId());
        cart.addProduct(product3.getId());
        System.out.println(cart.addProduct(1));
        System.out.println(cart.removeProduct(1));

        System.out.println(applicationContext.getBean(CartService.class));
        System.out.println(applicationContext.getBean(CartService.class));
    }
}
