package ua.ithillel.lesson32.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.ithillel.lesson32.homework.entity.Order;

@Service
public interface OrderRepository extends JpaRepository<Order, Long> {
}
