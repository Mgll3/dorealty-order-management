package com.doreality.order_management.service.interfaces;

import com.doreality.order_management.model.dto.request.product.ProductSaveDto;
import com.doreality.order_management.model.dto.response.product.ProductResponse;

public interface IProductService {

    public ProductResponse saveProduct(ProductSaveDto productSaveDto);

}
