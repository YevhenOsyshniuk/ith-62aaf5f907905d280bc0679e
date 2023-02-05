package ua.ithillel.lesson32.homework.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "orders")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Order {
    @Id
    @GeneratedValue
    long id;
    String name;
    @Column(name = "price")
    BigDecimal cost;
    @OneToMany
    @JoinTable(
            name = "orders_products",
            joinColumns = {@JoinColumn(name = "orders_id", nullable = false)},
            foreignKey = @ForeignKey(name = "fk_orders"),
            inverseJoinColumns = {@JoinColumn(name = "products_id", nullable = false)},
            inverseForeignKey = @ForeignKey(name = "fk_products")
    )
    List<Product> products;
}
