package org.example.validators;

import org.example.Model.Client;

import java.util.NoSuchElementException;

/**
 * A validator for client age.
 */
public class AgeValidator implements Validator<Client> {

    /**
     * Validates the age of a client.
     *
     * @param client The client to validate.
     * @throws NoSuchElementException If the client's age is below 18.
     */
    public void validate(Client client) {
        if (client.getAge() < 18) {
            throw new NoSuchElementException("Too young");
        }
    }
}
