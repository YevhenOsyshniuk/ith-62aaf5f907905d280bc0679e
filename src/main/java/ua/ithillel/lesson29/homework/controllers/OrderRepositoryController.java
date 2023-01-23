package ua.ithillel.lesson29.homework.controllers;

import lombok.RequiredArgsConstructor;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.lesson29.homework.entity.OrderRepository;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderRepositoryController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderRepositoryController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public String byId(@PathVariable("id") long id, Model model) {
        model.addAttribute("orders", orderRepository.getOrderById(id));
        return "orders/id";
    }

    @GetMapping()
    public String allOrders(Model model) {
        model.addAttribute("orders", orderRepository.getOrderList());
        return "/orders/allOrders";
    }
}
