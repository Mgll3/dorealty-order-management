package com.doreality.order_management.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doreality.order_management.model.dto.request.order.CustomerOrderSaveDto;
import com.doreality.order_management.model.dto.response.order.CustomerOrderResponse;
import com.doreality.order_management.model.entity.CustomerOrder;

@Component
public class CustomerOrderMapper {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    public CustomerOrderResponse toResponse(CustomerOrder entity) {
        CustomerOrderResponse ordeResponse = new CustomerOrderResponse();
        ordeResponse.setCustomerOrderId(entity.getId());
        ordeResponse.setOrderDetail(orderDetailMapper.toResponse(entity.getOrderDetail()));
        ordeResponse.setCreationDate(entity.getCreationDate());
        ordeResponse.setTotalPrice(entity.getTotalPrice());

        return ordeResponse;
    }

    public CustomerOrder toEntity(CustomerOrderSaveDto dto) {
        CustomerOrder entity = new CustomerOrder();
        // entity.setCustumer(dto.getCustumerEmail());
        // entity.setOrderDetail(dto.getOrderDetail());

        return entity;
    }

}
