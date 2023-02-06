package ua.ithillel.homework.lesson33.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ithillel.homework.lesson33.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
