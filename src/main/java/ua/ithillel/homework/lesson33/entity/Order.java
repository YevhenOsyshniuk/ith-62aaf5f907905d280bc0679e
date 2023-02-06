package ua.ithillel.homework.lesson33.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Order {
    @Id
    @GeneratedValue
    long id;
    @Column(name = "name")
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
