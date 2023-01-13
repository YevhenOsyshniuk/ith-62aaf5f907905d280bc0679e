package ua.ithillel.homework.lesson28.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PACKAGE)
public class Cart {
    private long id;
    private String name;
    private List<Product> productsInCart;
}
