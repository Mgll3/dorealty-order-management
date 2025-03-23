package com.doreality.order_management.model.dto.request.payment;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentSaveDto {

    private String custumerEmail;

    @NotNull(message = "Customer order id is required")
    private UUID customerOrderId;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    @NotNull(message = "Amount paid is required")
    private Double amountPaid;

}
