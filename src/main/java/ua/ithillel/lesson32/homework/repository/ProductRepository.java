package ua.ithillel.lesson32.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ithillel.lesson32.homework.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
