package com.doreality.order_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.doreality.order_management.model.dto.request.payment.PaymentSaveDto;
import com.doreality.order_management.model.dto.response.payment.PaymentResponse;
import com.doreality.order_management.service.implementation.SecurityService;
import com.doreality.order_management.service.interfaces.IPaymentService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private SecurityService securityService;

    @Operation(summary = "Crear un nuevo pago", description = "Endpoint para guadar un nuevo pago para un pedido ya creado", tags = {
            "Pagos" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Creación exitosa", content = @Content(schema = @Schema(implementation = PaymentSaveDto.class))),
            @ApiResponse(responseCode = "401", description = "No autorizado - Error al autenticar", content = @Content(schema = @Schema(implementation = PaymentSaveDto.class))),
            @ApiResponse(responseCode = "501", description = "Error al procesar la solicitud", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/save")
    public ResponseEntity<PaymentResponse> savePayment(@Valid @RequestBody PaymentSaveDto paymentSaveDto,
            HttpServletRequest request) {

        // Get email from token
        String custumerEmail = securityService.getEmail(request);

        paymentSaveDto.setCustumerEmail(custumerEmail);

        return new ResponseEntity<>(paymentService.savePayment(paymentSaveDto),
                HttpStatus.CREATED);
    }

}
