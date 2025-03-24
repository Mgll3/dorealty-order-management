package com.doreality.order_management.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doreality.order_management.model.dto.request.payment.PaymentSaveDto;
import com.doreality.order_management.model.dto.response.payment.PaymentResponse;
import com.doreality.order_management.model.repository.PaymentRepository;
import com.doreality.order_management.service.interfaces.IPaymentService;
import com.doreality.order_management.service.mapper.PaymentMapper;

import jakarta.transaction.Transactional;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    @Transactional
    public PaymentResponse savePayment(PaymentSaveDto paymentSaveDto) {

        return paymentMapper.toResponse(paymentRepository.save(
                paymentSaveDto.getCustomerOrderId(),
                paymentSaveDto.getCustumerEmail(),
                paymentSaveDto.getPaymentMethod(),
                paymentSaveDto.getAmountPaid()));
    }

}
