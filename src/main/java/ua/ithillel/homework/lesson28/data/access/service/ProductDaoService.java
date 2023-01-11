package ua.ithillel.homework.lesson28.data.access.service;

import ua.ithillel.homework.lesson28.data.access.service.DaoService;
import ua.ithillel.homework.lesson28.entity.Product;

import java.util.Optional;

public interface ProductDaoService extends DaoService<Product> {
    @Override
    Optional<Product> findById(long id);

    @Override
    void add(Product product);

    @Override
    void remove(long id);

    Iterable<Product> findAll();
}
