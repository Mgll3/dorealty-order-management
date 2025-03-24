package com.doreality.order_management.model.dto.response.payment;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentResponse {

    private UUID id;
    private String paymentMethod;
    private Double amountPaid;
    private LocalDateTime paymentDate;

}
