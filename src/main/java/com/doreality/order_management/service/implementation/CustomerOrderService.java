package com.doreality.order_management.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doreality.order_management.model.dto.request.order.CustomerOrderSaveDto;
import com.doreality.order_management.model.dto.response.order.CustomerOrderResponse;
import com.doreality.order_management.model.repository.CustomerOrderRepository;
import com.doreality.order_management.service.interfaces.ICustomerOrderService;
import com.doreality.order_management.service.mapper.CustomerOrderMapper;
import jakarta.transaction.Transactional;

@Service
public class CustomerOrderService implements ICustomerOrderService {

    @Autowired
    private CustomerOrderRepository orderRepository;

    @Autowired
    private CustomerOrderMapper orderMapper;

    @Override
    @Transactional
    public CustomerOrderResponse saveCustomerOrder(CustomerOrderSaveDto orderSaveDto) {

        return orderMapper.toResponse(orderRepository.save(
                orderSaveDto.getCustumerEmail(),
                orderSaveDto.getOrderDetail().getProduct().getId(),
                orderSaveDto.getOrderDetail().getQuantity()));
    }

}
