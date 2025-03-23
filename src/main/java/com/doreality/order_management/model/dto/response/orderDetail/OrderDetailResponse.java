package com.doreality.order_management.model.dto.response.orderDetail;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetailResponse {

    private UUID id;
    private UUID productId;
    private Integer quantity;

}
