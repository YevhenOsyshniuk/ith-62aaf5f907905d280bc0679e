package ua.ithillel.lesson32.homework.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Table(name = "products")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Product {
    @Id
    @GeneratedValue
    long id;
    String name;
    @Column(name = "price")
    BigDecimal cost;
}
