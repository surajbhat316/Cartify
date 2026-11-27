package com.abig.Caritfy.dto.product;

import com.abig.Caritfy.model.Product;

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
