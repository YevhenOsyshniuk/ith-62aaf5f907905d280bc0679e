package ua.ithillel.homework.lesson28.entity;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    public List<Product> productsInCart;
}
