package ua.ithillel.homework.lesson28.data.access.dao;

import ua.ithillel.homework.lesson28.entity.Product;

import java.util.Optional;

public interface ProductDao extends AbstractDao<Product> {
    @Override
    Optional<Product> findById(long id);

    @Override
    void add(Product product);

    @Override
    void removeById(long id);

    Iterable<Product> findAll();
}
