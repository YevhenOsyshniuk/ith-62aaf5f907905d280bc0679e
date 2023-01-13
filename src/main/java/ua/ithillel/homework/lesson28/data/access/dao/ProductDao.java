package ua.ithillel.homework.lesson28.data.access.dao;

import ua.ithillel.homework.lesson28.entity.Product;

import java.util.Optional;

public interface ProductDao extends AbstractDao<Product> {
    Iterable<Product> findAll();
}
