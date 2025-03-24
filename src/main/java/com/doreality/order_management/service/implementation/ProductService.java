package com.doreality.order_management.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doreality.order_management.model.dto.request.product.ProductSaveDto;
import com.doreality.order_management.model.dto.response.product.ProductResponse;
import com.doreality.order_management.model.repository.ProductRepository;
import com.doreality.order_management.service.interfaces.IProductService;
import com.doreality.order_management.service.mapper.ProductMapper;

import jakarta.transaction.Transactional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponse saveProduct(ProductSaveDto productSaveDto) {

        return productMapper.toResponse(productRepository.save(
                productSaveDto.getCustumerEmail(),
                productSaveDto.getName(),
                productSaveDto.getPrice(),
                productSaveDto.getStock()));

    }

}
