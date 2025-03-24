package com.doreality.order_management.service.mapper;

import org.springframework.stereotype.Component;

import com.doreality.order_management.model.dto.response.payment.PaymentResponse;
import com.doreality.order_management.model.entity.Payment;

@Component
public class PaymentMapper {

    public PaymentResponse toResponse(Payment entity) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setId(entity.getId());
        paymentResponse.setPaymentDate(entity.getPaymentDate());
        paymentResponse.setPaymentMethod(entity.getPaymentMethod());
        paymentResponse.setAmountPaid(entity.getAmountPaid());

        return paymentResponse;
    }
}
