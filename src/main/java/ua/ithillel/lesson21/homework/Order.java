package ua.ithillel.lesson21.homework;
public class Order {
    String name;
    int number;
    public Order() {
    }
    public Order(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return number + "  |  " + name;
    }
}