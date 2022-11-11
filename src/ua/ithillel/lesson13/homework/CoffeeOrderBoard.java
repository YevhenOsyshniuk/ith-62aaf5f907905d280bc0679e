package ua.ithillel.lesson13.homework;

import java.util.ArrayDeque;
import java.util.Queue;

public class CoffeeOrderBoard {

    private Queue<Order> orders = new ArrayDeque<>();

    private int orderNumber = 0;

    public void add(String name) {
        orderNumber++;
        orders.add(new Order(name, orderNumber));
    }

    public Order deliver() {
        return orders.poll();

    }

    public Order deliver(int orderNumber) {
        Order tempOrder = new Order();
        for (Order order : orders) {
            if (order.getNumber() == orderNumber) {
                tempOrder = order;
                orders.remove(order);
            }
            return tempOrder;
        }
        return new Order("Empty order", 0);
    }

    public void draw() {
        System.out.println("===============");
        System.out.println("Num  |  Name");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
