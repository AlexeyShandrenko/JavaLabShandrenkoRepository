package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
