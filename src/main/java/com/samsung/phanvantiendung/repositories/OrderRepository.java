package com.samsung.phanvantiendung.repositories;

import com.samsung.phanvantiendung.repositories.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
