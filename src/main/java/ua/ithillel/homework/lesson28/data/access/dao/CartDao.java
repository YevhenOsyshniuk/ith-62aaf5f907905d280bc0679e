package ua.ithillel.homework.lesson28.data.access.dao;

import ua.ithillel.homework.lesson28.entity.Cart;
import ua.ithillel.homework.lesson28.entity.Product;

import java.util.Optional;

public interface CartDao extends AbstractDao<Cart>{
    @Override
    Optional<Cart> findById(long id);

    @Override
    void add(Product product);

    @Override
    void removeById(long id);
}
