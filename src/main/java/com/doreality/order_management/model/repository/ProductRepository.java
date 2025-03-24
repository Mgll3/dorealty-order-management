package com.doreality.order_management.model.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.doreality.order_management.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value = "exec sp_CreateProduct " +
            "@user_email = :userEmail, " +
            "@name = :name, " +
            "@price = :price, " +
            "@stock = :stock", nativeQuery = true)
    public Product save(@Param("userEmail") String userEmail,
            @Param("name") String name,
            @Param("price") Double price,
            @Param("stock") Integer stock);
}
