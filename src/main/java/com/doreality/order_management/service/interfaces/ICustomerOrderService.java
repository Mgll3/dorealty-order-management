package com.doreality.order_management.service.interfaces;

import com.doreality.order_management.model.dto.request.order.CustomerOrderSaveDto;
import com.doreality.order_management.model.dto.response.order.CustomerOrderResponse;

public interface ICustomerOrderService {

    public CustomerOrderResponse saveCustomerOrder(CustomerOrderSaveDto orderSaveDto);
}
