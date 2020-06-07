package com.example.webstore.repos;

import com.example.webstore.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Override
    List<Orders> findAll();

    @Override
    Orders getOne(Long aLong);

    Orders findOrdersByProductId(Long id);

    @Query("select sum(o.orderPrice) from Orders o")
    Integer getSum();

}
