package org.example.validators;

/**
 * Interface for validating objects of a specific type.
 *
 * @param <T> The type of object to validate.
 */
public interface Validator<T> {

    /**
     * Validates the specified object.
     *
     * @param t The object to validate.
     */
    default void validate(T t) {
        // Implement validation logic here
    }
}
