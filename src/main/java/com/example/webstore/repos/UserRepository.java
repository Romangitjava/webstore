package com.example.webstore.repos;


import com.example.webstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
     User findByUsername(String username);
}
