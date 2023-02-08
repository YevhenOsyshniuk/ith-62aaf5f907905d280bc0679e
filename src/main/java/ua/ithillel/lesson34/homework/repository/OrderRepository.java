package ua.ithillel.lesson34.homework.repository;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

import org.springframework.stereotype.Repository;
import ua.ithillel.lesson34.homework.entity.Order;
import ua.ithillel.lesson34.homework.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Getter
public class OrderRepository {
    private final List<Order> orderList = new ArrayList<>();
    Order order;

    @PostConstruct
    public void postConstruct() {
        Product product1 = new Product(1, "name1", 3L);
        Product product2 = new Product(2, "name2", 2L);
        Product product3 = new Product(3, "name3", 3L);
        Product product4 = new Product(4, "name4", 4L);
        Order order1 = new Order(1, "order1", 6L, List.of(product1, product2, product3));
        Order order2 = new Order(2, "order2", 9L, List.of(product2, product3, product4));
        Order order3 = new Order(3, "order3", 7L, List.of(product1, product2, product4));
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
    }

    public Optional<Order> getOrderById(long id) {
        for (Order orders : orderList) {
            if (orders.getId() == id) {
                return Optional.of(orders);
            }
        }
        return null;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrderToOrderList() {
        orderList.add(order);
    }

}
