package ua.ithillel.homework.lesson33.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ithillel.homework.lesson33.entity.Order;
import ua.ithillel.homework.lesson33.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void add(Order order) {
        orderRepository.save(order);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }

}
