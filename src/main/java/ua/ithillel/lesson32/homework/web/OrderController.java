package ua.ithillel.lesson32.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.lesson32.homework.entity.Order;
import ua.ithillel.lesson32.homework.entity.Product;
import ua.ithillel.lesson32.homework.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String findById(Model uiModel, @PathVariable(value = "id") long id) {
        Optional<Order> product = orderRepository.findById(id);
        product.ifPresent(value -> uiModel.addAttribute("order", value));
        return "order";
    }

    @RequestMapping(path = "/allOrders", method = RequestMethod.GET)
    @ResponseBody
    public String findAll(Model uiModel) {
        uiModel.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }
}
