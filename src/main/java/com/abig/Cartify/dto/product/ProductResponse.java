package com.abig.Cartify.dto.product;

import com.abig.Cartify.model.Product;

public record ProductResponse(
        int productId,
        String name,
        String description,
        int price
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
