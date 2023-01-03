package ua.ithillel.lesson27.homework.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.ithillel.lesson27.homework.entity.Product;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class CartService {
    public List<Product> productsInCart = new ArrayList<>();
    ProductRepository productRepository;

    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> addProduct(long id) {
        for (Product product : productRepository.getAllProducts()) {
            if (product.getId() == id) {
                productsInCart.add(product);
            }
        }
        return productsInCart.stream().toList();
    }

    public List<Product> removeProduct(int id) {
        productsInCart.removeIf(product -> product.getId() == id);
        return productsInCart.stream().toList();
    }

    @Override
    public String toString() {
        return "CartService[]" + this.hashCode() + " product repository : " + productRepository.hashCode();
    }
}
