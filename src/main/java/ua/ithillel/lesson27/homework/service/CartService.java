package ua.ithillel.lesson27.homework.service;

import org.springframework.context.annotation.Scope;;
import org.springframework.stereotype.Service;
import ua.ithillel.lesson27.homework.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Scope("prototype")
public class CartService {
    public List<Product> productsInCart = new ArrayList<>();
    ProductRepository productRepository;

    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void cartApplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of product to add it to the cart");
        long id = scanner.nextLong();
        addProductById(id);
        System.out.println("To add product to cart press - 1,to delete press - 2");
        long variant = scanner.nextLong();
        switch ((int) variant) {
            case 1 -> {
                addProductById(id);
                System.out.println("Product with id " + id + " added");
            }
            case 2 -> {
                removeProductById(id);
                System.out.println("Product with id " + id + " removed");
            }
            default -> System.out.println("Wrong choice");
        }
        repeatCartApplication();
    }

    public void repeatCartApplication() {
        System.out.println("One more time use cart? yes - press 1, no - press 2");
        Scanner scanner = new Scanner(System.in);
        int variant1 = scanner.nextInt();
        if (variant1 == 2) {
            System.out.println("Bye bye");
        } else {
            cartApplication();
        }
    }
    public List<Product> addProductById(long id) {
        productsInCart.add(productRepository.getProductById(id));
        return productsInCart;
    }

    public List<Product> removeProductById(long id) {
        productsInCart.removeIf(product -> product.getId() == id);
        return productsInCart;
    }


}
