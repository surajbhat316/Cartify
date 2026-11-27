package com.abig.Caritfy.service;

import com.abig.Caritfy.dto.product.CreateProductRequest;
import com.abig.Caritfy.dto.product.ProductResponse;
import com.abig.Caritfy.model.Product;
import com.abig.Caritfy.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> fetchedProducts =  this.productRepository.findAll();
        return fetchedProducts.stream()
                .map((ProductResponse::from))
                .toList();
    }

    public ProductResponse createProduct(@Valid CreateProductRequest request) {
        Product savedProduct = this.productRepository.save(request.toEntity());
        return ProductResponse.from(savedProduct);
    }
}
