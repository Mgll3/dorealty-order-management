package com.doreality.order_management.model.dto.response.order;

import java.time.LocalDate;
import java.util.UUID;

import com.doreality.order_management.model.dto.response.order_detail.OrderDetailResponse;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerOrderResponse {

    private UUID customerOrderId;
    private OrderDetailResponse orderDetail;
    private LocalDate creationDate;
    private Double totalPrice;

}
