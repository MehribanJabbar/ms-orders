package com.example.msorders.dao.repository;

import com.example.msorders.dao.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity , Long> {

    @Query(value = "SELECT o FROM OrderEntity o WHERE o.userId = :userId")
    List<OrderEntity> findAllByUserId(Long userId);

}
