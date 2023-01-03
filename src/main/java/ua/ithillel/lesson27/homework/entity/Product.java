package ua.ithillel.lesson27.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private final long id;
    private final String name;
    private final float price;
}
