package ua.ithillel.lesson15.homework;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {

        Product product1 = new Product(1, "Book", 50, true, LocalDateTime.of(2022, 11, 2, 11, 12));
        Product product2 = new Product(2, "Toy", 100, false, LocalDateTime.of(2022, 10, 2, 11, 12));
        Product product3 = new Product(3, "Car", 2000, true, LocalDateTime.of(2022, 12, 2, 11, 12));
        Product product4 = new Product(4, "Book", 280, true, LocalDateTime.of(2022, 1, 2, 11, 12));
        Product product5 = new Product(5, "Book", 300, false, LocalDateTime.of(2022, 2, 2, 11, 12));
        Product product6 = new Product(6, "Book", 10, false, LocalDateTime.of(2022, 3, 2, 11, 12));

        addToList(product1);
        addToList(product2);
        addToList(product3);
        addToList(product4);
        addToList(product5);
        addToList(product6);

        System.out.println("Продукты отфильтрованые по типу сценой не выше 250: " + filterByCategoryAndPrice("Book", 250));
        System.out.println("Продукты с дисконтом: " + filterByCategoryPriceDiscount("Book"));
        System.out.println("Самый дешевый продукт данного типа: " + getTheCheapestOne("Book"));
        System.out.println("Последние 3 добавленых елемента: " + getThreeLastProducts(listOfProducts));
        System.out.println("Общая стоимость продуктов ценой не выше 75: " + getTotalProductsCost(listOfProducts, "Book"));
        System.out.println("Отсортированые по типу продукты: " + groupByType(listOfProducts));
    }

    public static List<Product> listOfProducts = new ArrayList<>();

    public static List<Product> addToList(Product product) {
        listOfProducts.add(product);
        return listOfProducts;
    }

    public static List<Product> filterByCategoryAndPrice(String typeOfProduct, double price) {
        return listOfProducts.stream()
                .filter(t -> t.getTypeOfProduct().equals(typeOfProduct) && t.getPrice() > price)
                .toList();
    }

    public static List<Product> filterByCategoryPriceDiscount(String typeOfProduct) {
        return listOfProducts.stream().filter(t -> t.getTypeOfProduct().equals(typeOfProduct) && t.isDiscount())
                .map(t -> new Product(t.getID(), t.getTypeOfProduct(), t.getPrice() * 0.9F))
                .toList();
    }

    public static Product getTheCheapestOne(String typeOfProduct) throws NoSuchElementException {
        return Stream.of(listOfProducts)
                .flatMap(Collection::stream)
                .filter(e -> e.getTypeOfProduct().equals(typeOfProduct))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категория:" + typeOfProduct + "] не найден"));
    }

    public static List<Product> getThreeLastProducts(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .sorted((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()))
                .limit(3)
                .toList();
    }

    public static double getTotalProductsCost(List<Product> listOfProducts, String typeOfProduct) {
        return listOfProducts.stream()
                .filter(product -> product.getTypeOfProduct().equals(typeOfProduct)
                        && product.getPrice() <= 75
                        && product.getDateTime().getYear() == LocalDateTime.now().getYear())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupByType(List<Product> listOfProducts) {
        return listOfProducts.stream().collect(Collectors.groupingBy(Product::getTypeOfProduct));
    }
}

