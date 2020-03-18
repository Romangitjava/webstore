package com.example.webstore.repos;

import com.example.webstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Override
    List<Cart> findAll();

    @Override
    boolean existsById(Long aLong);
}
