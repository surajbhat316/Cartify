package com.abig.Caritfy.controller;

import com.abig.Caritfy.dto.product.CreateProductRequest;
import com.abig.Caritfy.dto.product.ProductResponse;
import com.abig.Caritfy.model.Product;
import com.abig.Caritfy.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PostMapping
    public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest request){
        return productService.createProduct(request);
    }
}
