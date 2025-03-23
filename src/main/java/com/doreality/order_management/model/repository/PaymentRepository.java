package com.doreality.order_management.model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.doreality.order_management.model.entity.Payment;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    @Query(value = "exec sp_CreatePayment " +
            "@customer_email = :custumerEmail, " +
            "@payment_method = :paymentMethod, " +
            "@amount_paid = :amountPaid", nativeQuery = true)
    public Payment save(@Param("custumerEmail") String custumerEmail,
            @Param("paymentMethod") String paymentMethod,
            @Param("amountPaid") Double amountPaid);
}
