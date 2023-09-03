package org.example.Model;

/**
 * Represents an order.
 */
public class Order {
    private int idOrder;
    private int idClient;
    private int idProduct;
    private int quantity;

    /**
     * Default constructor for Order.
     */
    public Order() {

    }

    /**
     * Constructor for Order with specified values.
     *
     * @param idOrder   The ID of the order.
     * @param idClient  The ID of the client.
     * @param idProduct The ID of the product.
     * @param quantity  The quantity of the product.
     */
    public Order(int idOrder, int idClient, int idProduct, int quantity) {
        this.idOrder = idOrder;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    /**
     * Get the ID of the order.
     *
     * @return The ID of the order.
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * Set the ID of the order.
     *
     * @param idOrder The ID of the order.
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    /**
     * Get the ID of the client.
     *
     * @return The ID of the client.
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Set the ID of the client.
     *
     * @param idClient The ID of the client.
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
     * @param idProduct The ID of the product.
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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
     * Returns a string representation of the order.
     *
     * @return A string representation of the order.
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + idOrder +
                ", idProduct='" + idProduct + '\'' +
                ", idClient='" + idClient + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
