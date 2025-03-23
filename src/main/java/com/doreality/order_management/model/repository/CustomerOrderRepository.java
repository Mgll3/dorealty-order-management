package com.doreality.order_management.model.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.doreality.order_management.model.entity.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, UUID> {

        @Query(value = "exec sp_CreateCustomerOrder " +
                        "@customer_email = :customerEmail, " +
                        "@product_id = :productId, " +
                        "@quantity = :quantity", nativeQuery = true)
        public CustomerOrder save(@Param("customerEmail") String customerEmail,
                        @Param("productId") UUID productId,
                        @Param("quantity") int quantity);
}