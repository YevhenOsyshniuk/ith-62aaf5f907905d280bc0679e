package ua.ithillel.lesson27.homework.service;

import org.springframework.stereotype.Component;
import ua.ithillel.lesson27.homework.entity.Product;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private final List<Product> productsInRepos = new ArrayList<>();

    @PostConstruct
    private void postConstruct() {
        Product product1 = new Product(1, "name 1", 10);
        Product product2 = new Product(2, "name 2", 20);
        Product product3 = new Product(3, "name 3", 30);
        productsInRepos.add(product2);
        productsInRepos.add(product1);
        productsInRepos.add(product3);
        System.out.println("Products : " + product1 + " " + product2 + " " + product3 + " added");
    }

    public void add(Product product) {
        productsInRepos.add(product);
    }

    public void remove(Product product) {
        productsInRepos.remove(product);
    }

    public Product getProductById(long id) {
        for (Product product : productsInRepos) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return productsInRepos.stream().toList();
    }
}
