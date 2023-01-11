package ua.ithillel.homework.lesson28.data.access.service;

import ua.ithillel.homework.lesson28.entity.Product;

import java.util.Optional;


public interface DaoService<T> {
    Optional<Product> findById(long id);

    void add(Product product);

    void remove(long id);

}
