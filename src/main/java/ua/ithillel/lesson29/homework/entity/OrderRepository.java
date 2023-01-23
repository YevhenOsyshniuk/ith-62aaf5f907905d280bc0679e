package ua.ithillel.lesson29.homework.entity;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Getter
public class OrderRepository {
    List<Order> orderList;
    Order order;

    @PostConstruct
    public void postConstruct() {
        Product product1 = new Product(1, "name1", 1);
        Product product2 = new Product(2, "name2", 2);
        Product product3 = new Product(3, "name3", 3);
        Product product4 = new Product(4, "name4", 4);
        Order order1 = new Order(1, LocalDateTime.now(), 6, List.of(product1, product2, product3));
        Order order2 = new Order(2, LocalDateTime.now(), 9, List.of(product2, product3, product4));
        Order order3 = new Order(3, LocalDateTime.now(), 7, List.of(product1, product2, product4));
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
    }

    public Order getOrderById(long id) {
        for (Order orders : orderList) {
            if (orders.getId() == id) {
                return orders;
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
