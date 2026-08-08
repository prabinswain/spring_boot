package com.mapstructs_demo.repository;

import com.mapstructs_demo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<OrderEntity, String> {
}
