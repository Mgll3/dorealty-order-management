package com.doreality.order_management.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doreality.order_management.model.dto.response.orderDetail.OrderDetailResponse;
import com.doreality.order_management.model.entity.OrderDetail;

@Component
public class OrderDetailMapper {

    public OrderDetailResponse toResponse(OrderDetail entity) {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setId(entity.getId());
        orderDetailResponse.setProductId(entity.getProduct().getId());
        orderDetailResponse.setQuantity(entity.getQuantity());

        return orderDetailResponse;
    }

}
