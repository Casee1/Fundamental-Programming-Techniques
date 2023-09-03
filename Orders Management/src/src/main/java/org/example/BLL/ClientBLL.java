package org.example.BLL;

import org.example.DAO.ClientDAO;
import org.example.Model.Client;
import org.example.validators.AgeValidator;
import org.example.validators.EmailValidator;
import org.example.validators.Validator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Business logic layer for handling client operations.
 */
public class ClientBLL {
    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    /**
     * Constructs a new ClientBLL object.
     */
    public ClientBLL() {
        validators = new ArrayList<>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());
        clientDAO = new ClientDAO();
    }

    /**
     * Finds a client by ID.
     *
     * @param id The ID of the client to find.
     * @return The found client.
     * @throws NoSuchElementException If the client with the specified ID was not found.
     */
    public Client findClientById(int id) {
        Client client = clientDAO.findById(id,"idClient");
        if (client == null) {
            throw new NoSuchElementException("The client with ID = " + id + " was not found!");
        }
        return client;
    }

    /**
     * Inserts a new client.
     *
     * @param client The client to insert.
     * @throws IllegalArgumentException If the client is not valid according to the defined validators.
     */
    public void insertClient(Client client) {
        for (Validator<Client> validator : validators) {
            validator.validate(client);
        }
        clientDAO.insert(client);
    }

    /**
     * Deletes a client by ID.
     *
     * @param id The ID of the client to delete.
     */
    public void deleteClient(int id) {
        clientDAO.delete("idClient", id);
    }

    /**
     * Updates a client with new information.
     *
     * @param client The updated client object.
     * @param id     The ID of the client to update.
     * @throws IllegalAccessException If the update operation encounters an access exception.
     */
    public void updateClient(Client client, int id) throws IllegalAccessException {
        clientDAO.update(client, id, "idClient");
    }

    /**
     * Retrieves all clients.
     *
     * @return A list of all clients.
     */
    public List<Client> findAllClient() {
        return clientDAO.findAll();
    }

    /**
     * Creates a JTable representation of clients.
     *
     * @param clients The list of clients.
     * @return The JTable object representing the clients.
     */
    public JTable clientTable(ArrayList<Client> clients) {
        return clientDAO.jTable(clients);
    }
}
