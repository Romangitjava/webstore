package com.example.webstore.repos;

import com.example.webstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    List<Product> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    Product getOne(Long id);




    @Query("select p from Product p where p.model like ?1% or p.manufacturer like ?1% or p.productTypes like ?1% or p.description like ?1%")
    List<Product> searchProducts(@Param("keyword") String keyword);

    @Query("select p from Product p where p.productTypes = 'Компьютеры'")
    List<Product> showComputers();

    @Query("select p from Product p where p.productTypes = 'Телевизоры'")
    List<Product> showTV();

    @Query("select p from Product p  where p.productTypes = 'Телефоны' ")
    List<Product> showPhones();

    @Query("select p from Product p  where p.productTypes = 'Аксессуары' ")
    List<Product> showAccessories();

    @Query("select p from Product p  where p.productTypes = 'Бытовая техника' ")
    List<Product> showAppliances();


    Optional<Product> findById(Long id);
}
