package org.example.validators;

import org.example.Model.Product;

import java.util.NoSuchElementException;

/**
 * Validator for validating the price of a product.
 */
public class ProductPriceValidator implements Validator<Product> {

    /**
     * Validates the price of the specified product.
     *
     * @param product The product to validate.
     * @throws NoSuchElementException If the price is less than 0.
     */
    public void validate(Product product) {
        if (product.getPrice() < 0) {
            throw new NoSuchElementException("Invalid price: " + product.getPrice());
        }
    }
}
