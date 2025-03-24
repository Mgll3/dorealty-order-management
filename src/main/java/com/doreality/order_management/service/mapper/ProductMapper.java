package com.doreality.order_management.service.mapper;

import org.springframework.stereotype.Component;
import com.doreality.order_management.model.dto.response.product.ProductResponse;
import com.doreality.order_management.model.entity.Product;

@Component
public class ProductMapper {

    public ProductResponse toResponse(Product entity) {
        ProductResponse response = new ProductResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setPrice(entity.getPrice());
        response.setStock(entity.getStock());

        return response;

    }
}
