package ua.ithillel.lesson21.homework;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Queue;

public class CoffeeOrderBoard {
    private static final Logger log = LogManager.getLogger(CoffeeOrderBoard.class);
    private Queue<Order> orders = new ArrayDeque<>();
    private int orderNumber = 0;

    public void add(String name) {
        log.info("Adding new name: " + name + " to the queue in {}", getClass());
        orderNumber++;
        try {
            orders.add(new Order(name, orderNumber));
        } catch (NullPointerException | IllegalArgumentException | ClassCastException | IllegalStateException e) {
            log.log(Level.ERROR, "Exception logged in {}", getClass(), e);
        }
    }

    public Order deliver() {
        log.info("Getting nearest deliver: " + orders + " in {}", getClass());
        return orders.poll();
    }

    public Order deliver(int orderNumber) {
        Order tempOrder = new Order();
        for (Order order : orders) {
            if (order.getNumber() == orderNumber) {
                tempOrder = order;
                try {
                    orders.remove(order);
                } catch (ClassCastException | NullPointerException | UnsupportedOperationException e) {
                    log.log(Level.ERROR, "Exception logged in {}", getClass(), e);
                }

            }
            log.info("Getting nearest deliver with number: " + orderNumber + " in {}", getClass());
            return tempOrder;
        }
        log.info("Can not get order " + orderNumber + " in {}", getClass());
        return new Order("Empty order", 0);
    }

    public void draw() {
        log.info("Getting current queue in {}", getClass());
        System.out.println("===============");
        System.out.println("Num  |  Name");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
