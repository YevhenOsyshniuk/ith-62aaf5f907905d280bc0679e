package ua.ithillel.lesson34.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.lesson34.homework.entity.Order;
import ua.ithillel.lesson34.homework.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderRepositoryController {

    private final OrderRepository orderRepository;

    public OrderRepositoryController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable long id) {
        Optional<Order> order = orderRepository.getOrderById(id);
        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order.get());
    }

    @GetMapping("/allOrders")
    public List<Order> allOrders() {
        return orderRepository.getOrderList();
    }
}
