package com.doreality.order_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.doreality.order_management.model.dto.request.product.ProductSaveDto;
import com.doreality.order_management.model.dto.response.product.ProductResponse;
import com.doreality.order_management.service.implementation.SecurityService;
import com.doreality.order_management.service.interfaces.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private SecurityService securityService;

    @Operation(summary = "Crear un nuevo producto", description = "Endpoint para guardar un nuevo producto, Solo ADMIN", tags = {
            "Producto" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Creación exitosa", content = @Content(schema = @Schema(implementation = ProductSaveDto.class))),
            @ApiResponse(responseCode = "401", description = "No autorizado - Error al autenticar", content = @Content(schema = @Schema(implementation = ProductSaveDto.class))),
            @ApiResponse(responseCode = "501", description = "Error al procesar la solicitud", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/save")
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductSaveDto productSaveDto,
            HttpServletRequest request) {

        // Get email from token
        String custumerEmail = securityService.getEmail(request);

        productSaveDto.setCustumerEmail(custumerEmail);

        return new ResponseEntity<>(productService.saveProduct(productSaveDto),
                HttpStatus.CREATED);
    }
}
