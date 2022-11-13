package ua.ithillel.lesson21.homework;

public class Application {

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Alen");
        coffeeOrderBoard.add("Yoda");
        coffeeOrderBoard.add("Obi-van");
        coffeeOrderBoard.add("John Snow");
        System.out.println(coffeeOrderBoard.deliver());
        System.out.println(coffeeOrderBoard.deliver(4));
        coffeeOrderBoard.draw();
    }
}
