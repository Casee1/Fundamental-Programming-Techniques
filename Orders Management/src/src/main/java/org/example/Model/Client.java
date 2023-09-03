package org.example.Model;

/**
 * Represents a client.
 */
public class Client {
    private int idClient;
    private String name;
    private int age;
    private String address;
    private String email;

    /**
     * Constructor for Client with specified values.
     *
     * @param id      The ID of the client.
     * @param name    The name of the client.
     * @param age     The age of the client.
     * @param address The address of the client.
     * @param email   The email of the client.
     */
    public Client(int id, String name, int age, String address, String email) {
        this.idClient = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    /**
     * Default constructor for Client.
     */
    public Client() {

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
     * @param id The ID of the client.
     */
    public void setIdClient(int id) {
        this.idClient = id;
    }

    /**
     * Get the name of the client.
     *
     * @return The name of the client.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the client.
     *
     * @param name The name of the client.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the age of the client.
     *
     * @return The age of the client.
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the age of the client.
     *
     * @param age The age of the client.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the address of the client.
     *
     * @return The address of the client.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the client.
     *
     * @param address The address of the client.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the email of the client.
     *
     * @return The email of the client.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the client.
     *
     * @param email The email of the client.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the client.
     *
     * @return A string representation of the client.
     */
    @Override
    public String toString() {
        return "Client [id=" + idClient + ", name=" + name + ", address=" + address + ", email=" + email + ", age=" + age
                + "]";
    }
}
