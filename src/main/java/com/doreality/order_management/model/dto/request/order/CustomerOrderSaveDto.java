package com.doreality.order_management.model.dto.request.order;

import com.doreality.order_management.model.entity.OrderDetail;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerOrderSaveDto {

    @NotBlank(message = "Customer name is required")
    private String custumerEmail;

    @NotNull(message = "Order detail is required")
    private OrderDetail orderDetail;

}
