package org.example.validators;

import org.example.Model.Product;

import java.util.NoSuchElementException;

public class ProductQuantityValidator implements Validator<Product>{

    public void validate(Product product) {
        if (product.getQuantity() < 0) {
            throw new NoSuchElementException("Invalid quantity: ");
        }
    }
}
