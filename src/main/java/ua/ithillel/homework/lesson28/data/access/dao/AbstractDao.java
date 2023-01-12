package ua.ithillel.homework.lesson28.data.access.dao;

import ua.ithillel.homework.lesson28.entity.Product;

import java.util.Optional;


public interface AbstractDao<T> {
    Optional<T> findById(long id);

    void add(Product product);

    void removeById(long id);

}
