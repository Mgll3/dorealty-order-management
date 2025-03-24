package com.doreality.order_management.model.dto.response.product;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponse {

    private UUID id;
    private String name;
    private Double price;
    private Integer stock;

}
