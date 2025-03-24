package com.doreality.order_management.service.interfaces;

import com.doreality.order_management.model.dto.request.payment.PaymentSaveDto;
import com.doreality.order_management.model.dto.response.payment.PaymentResponse;

public interface IPaymentService {

    public PaymentResponse savePayment(PaymentSaveDto paymentSaveDto);
}
