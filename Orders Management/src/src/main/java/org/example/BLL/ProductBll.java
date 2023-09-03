package org.example.BLL;

import org.example.DAO.ProductDAO;
import org.example.Model.Product;
import org.example.validators.ProductPriceValidator;
import org.example.validators.Validator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Business logic layer for handling product operations.
 */
public class ProductBll {
    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    /**
     * Constructs a new ProductBll object.
     */
    public ProductBll() {
        validators = new ArrayList<>();
        validators.add(new ProductPriceValidator());
        productDAO = new ProductDAO();
    }

    /**
     * Finds a product by its ID.
     *
     * @param id The ID of the product.
     * @return The found product.
     * @throws NoSuchElementException If the product with the specified ID was not found.
     */
    public Product findProductById(int id) {
        Product product = productDAO.findById(id,"idProduct");
        if (product == null) {
            throw new NoSuchElementException("The product with ID = " + id + " was not found!");
        }
        return product;
    }

    /**
     * Inserts a new product.
     *
     * @param product The product to insert.
     * @throws IllegalArgumentException If the product is not valid according to the defined validators.
     */
    public void insertProduct(Product product) {
        for (Validator<Product> validator : validators) {
            validator.validate(product);
        }
        productDAO.insert(product);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     */
    public void deleteProduct(int id) {
        productDAO.delete("idProduct", id);
    }

    /**
     * Updates a product.
     *
     * @param product The updated product.
     * @param id      The ID of the product to update.
     * @throws IllegalAccessException If the update operation is not allowed.
     */
    public void updateProduct(Product product, int id) throws IllegalAccessException {
        productDAO.update(product, id, "idProduct");
    }

    /**
     * Retrieves all products.
     *
     * @return A list of all products.
     */
    public List<Product> findAllProduct() {
        return productDAO.findAll();
    }

    /**
     * Creates a JTable representation of products.
     *
     * @param products The list of products.
     * @return The JTable object representing the products.
     */
    public JTable productTable(ArrayList<Product> products) {
        return productDAO.jTable(products);
    }
}
