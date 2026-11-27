package com.abig.Cartify.controller;

import com.abig.Cartify.dto.common.PagedResponse;
import com.abig.Cartify.dto.product.CreateProductRequest;
import com.abig.Cartify.dto.product.ProductResponse;
import com.abig.Cartify.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public PagedResponse<ProductResponse> getAllProducts(
            @PageableDefault(page = 0, size = 10, sort = "productId", direction = Sort.Direction.ASC)
            Pageable pageable
    ) {
        return this.productService.getAllProducts(pageable);
    }

    @PostMapping
    public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest request){
        return productService.createProduct(request);
    }
}
