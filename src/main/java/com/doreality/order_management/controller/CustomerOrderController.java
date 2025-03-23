package com.doreality.order_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.doreality.order_management.model.dto.request.order.CustomerOrderSaveDto;
import com.doreality.order_management.model.dto.response.order.CustomerOrderResponse;
import com.doreality.order_management.service.implementation.SecurityService;
import com.doreality.order_management.service.interfaces.ICustomerOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/customer-order")
public class CustomerOrderController {

    @Autowired
    private ICustomerOrderService orderService;

    @Autowired
    private SecurityService securityService;

    @Operation(summary = "Crear un nuevo pedido", description = "Endpoint para crear un nuevo pedido para un cliente", tags = {
            "Pedidos" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Creación exitosa", content = @Content(schema = @Schema(implementation = CustomerOrderSaveDto.class))),
            @ApiResponse(responseCode = "401", description = "No autorizado - Error al autenticar", content = @Content(schema = @Schema(implementation = CustomerOrderSaveDto.class))),
            @ApiResponse(responseCode = "501", description = "Error al procesar la solicitud", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/save")
    public ResponseEntity<CustomerOrderResponse> saveCustomerOrder(
            @Valid @RequestBody CustomerOrderSaveDto orderSaveDto,
            HttpServletRequest request) {

        // Get email from token
        String custumerEmail = securityService.getEmail(request);

        orderSaveDto.setCustumerEmail(custumerEmail);

        return new ResponseEntity<>(orderService.saveCustomerOrder(orderSaveDto),
                HttpStatus.CREATED);
    }

}
