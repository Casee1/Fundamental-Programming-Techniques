package org.example.Model;

/**
 * Represents a product.
 */
public class Product {
    private int idProduct;
    private String name;
    private float price;
    private int quantity;

    /**
     * Default constructor for Product.
     */
    public Product() {

    }

    /**
     * Constructor for Product with specified values.
     *
     * @param id       The ID of the product.
     * @param name     The name of the product.
     * @param price    The price of the product.
     * @param quantity The quantity of the product.
     */
    public Product(int id, String name, float price, int quantity) {
        this.idProduct = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Get the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * Set the ID of the product.
     *
     * @param id The ID of the product.
     */
    public void setIdProduct(int id) {
        this.idProduct = id;
    }

    /**
     * Get the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the price of the product.
     *
     * @return The price of the product.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Set the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Get the quantity of the product.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the product.
     *
     * @param quantity The quantity of the product.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return A string representation of the product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + idProduct +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
