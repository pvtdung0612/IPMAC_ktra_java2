package com.samsung.phanvantiendung.repositories;

import com.samsung.phanvantiendung.repositories.models.OrderDetail;
import com.samsung.phanvantiendung.repositories.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
