package com.doreality.order_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doreality.order_management.model.dto.request.payment.PaymentSaveDto;
import com.doreality.order_management.service.implementation.SecurityService;
import com.doreality.order_management.service.interfaces.ICustomerOrderService;
import com.doreality.order_management.service.interfaces.IPaymentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private SecurityService securityService;

    @PostMapping("/save")
    public ResponseEntity<?> savePayment(@Valid @RequestBody PaymentSaveDto paymentSaveDto,
            HttpServletRequest request) {

        // Get email from token
        String custumerEmail = securityService.getEmail(request);

        paymentSaveDto.setCustumerEmail(custumerEmail);

        return new ResponseEntity<>(paymentService.savePayment(paymentSaveDto),
                HttpStatus.CREATED);
    }

}
