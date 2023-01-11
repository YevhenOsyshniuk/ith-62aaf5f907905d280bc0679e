package ua.ithillel.homework.lesson28.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PACKAGE)
public class Product {
    private long id;
    private String name;
    private  float price;
    Cart productsInCart;
}
