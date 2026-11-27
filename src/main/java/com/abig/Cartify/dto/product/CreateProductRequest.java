package com.abig.Cartify.dto.product;

import com.abig.Cartify.model.Product;
import jakarta.validation.constraints.*;

public record CreateProductRequest(
        @NotBlank(message = "Product name is required")
        @Size(max = 255, message = "Product name must not exceed 255 characters")
        String name,

        @Size(max = 255, message = "Description must not exceed 255 characters")
        String description,

        @NotNull(message = "Price Field Cannot be null")
        @Positive(message = "Price must be greater than 0")
        Integer price,

        @NotNull(message = "Quantity is required")
        @Min(value = 0, message = "Quantity must be greater than 0")
        Integer quantity
) {
    public Product toEntity() {
        Product product = new Product();
        product.setName(this.name.trim());
        product.setDescription(this.description != null ? this.description.trim() : null);
        product.setPrice(this.price);
        product.setQuantity(this.quantity);
        return product;
    }
}
