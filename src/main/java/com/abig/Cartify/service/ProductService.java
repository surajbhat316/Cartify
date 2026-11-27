package com.abig.Cartify.service;

import com.abig.Cartify.dto.common.PagedResponse;
import com.abig.Cartify.dto.product.CreateProductRequest;
import com.abig.Cartify.dto.product.ProductResponse;
import com.abig.Cartify.model.Product;
import com.abig.Cartify.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public PagedResponse<ProductResponse> getAllProducts(Pageable pageable) {
        Page<ProductResponse> response = this.productRepository.findAll(pageable)
                .map(ProductResponse::from);

        System.out.println(response);
        return PagedResponse.from(response);
    }

    public ProductResponse createProduct(@Valid CreateProductRequest request) {
        Product savedProduct = this.productRepository.save(request.toEntity());
        return ProductResponse.from(savedProduct);
    }
}
