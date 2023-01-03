package ua.ithillel.lesson27.homework.service;

import org.springframework.stereotype.Component;
import ua.ithillel.lesson27.homework.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    private final List<Product> productsInRepos = new ArrayList<>();

    public void add(Product product) {
        productsInRepos.add(product);
    }

    public void remove(Product product) {
        productsInRepos.remove(product);
    }

    public Optional<Product> getProduct(int id) {
        for (Product product : productsInRepos) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public List<Product> getAllProducts() {
        return productsInRepos;
    }
}
