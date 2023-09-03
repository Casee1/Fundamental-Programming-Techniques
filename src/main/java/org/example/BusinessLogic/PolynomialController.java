package org.example.BusinessLogic;

import org.example.Model.Polynomial;

import java.util.Map;

public class PolynomialController {

    public static Polynomial Derivate(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> term : polynomial.terms.entrySet()) {
            int exponent = term.getKey();
            double coefficient = term.getValue();
            if (exponent > 0) {
                double derivativeCoefficient = exponent * coefficient;
                result.terms.put(exponent - 1, derivativeCoefficient);
            }
        }
        return result;
    }

    public static Polynomial Integration(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> term : polynomial.terms.entrySet()) {
            int exponent = term.getKey();
            double coefficient = term.getValue();
            double integrationCoefficient = coefficient / (exponent + 1);
            result.terms.put(exponent + 1, integrationCoefficient);
        }
        return result;
    }

    public static Polynomial Addition(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Integer exponent : polynomial1.getExponents()) {
            double coefficient = polynomial1.getCoefficient(exponent);
            result.setTerms(coefficient, exponent);
        }

        for (Integer exponent : polynomial2.getExponents()) {
            double coefficient = polynomial2.getCoefficient(exponent);
            double sum = coefficient + result.getCoefficient(exponent);
            result.setTerms(sum, exponent);
        }
        return result;
    }

    public static Polynomial Substract(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Integer exponent : polynomial1.getExponents()) {
            double coefficient = polynomial1.getCoefficient(exponent);
            result.setTerms(coefficient, exponent);
        }

        for (Integer exponent : polynomial2.getExponents()) {
            double coefficient = polynomial2.getCoefficient(exponent);
            double diff = result.getCoefficient(exponent) - coefficient;
            result.setTerms(diff, exponent);
        }
        return result;
    }

    public static Polynomial Multiply(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Integer exponent1 : polynomial1.getExponents()) {
            double coefficient1 = polynomial1.getCoefficient(exponent1);
            for (Integer exponent2 : polynomial2.getExponents()) {
                double coefficient2 = polynomial2.getCoefficient(exponent2);
                double multiply = coefficient1 * coefficient2;
                int exponent = exponent1 + exponent2;
                double existingCoefficient = result.getCoefficient(exponent);
                double newCoefficient = existingCoefficient + multiply;
                result.setTerms(newCoefficient, exponent);
            }
        }
        return result;
    }

    public static Polynomial Division(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();
        int size1 = polynomial1.maxPower();
        int size2 = polynomial2.maxPower();
        if (size2 == 0 && polynomial2.terms.get(0) == 0) {
            throw new IllegalArgumentException("Cannot divide by zero polynomial");
        }
        int size = size1 - size2;
        if (size2 == 0) {
            double constant = polynomial2.terms.get(0);
            for (int i = 0; i <= size1; i++) {
                result.terms.put(i,polynomial1.getCoefficient(i)/constant);
            }
        } else if (size1 >= size2) {
            for (int i = 0; i <= size; i++) {
                Polynomial temp = new Polynomial();
                Integer power1 = polynomial1.maxPower();
                Integer power2 = polynomial2.maxPower();
                Integer power = power1 - power2;
                if (power >= 0) {
                    double coefficient = polynomial1.terms.get(power1) / polynomial2.terms.get(power2);
                    Polynomial monomial = new Polynomial();
                    monomial.terms.put(power, coefficient);
                    temp = Multiply(polynomial2, monomial);
                    polynomial1 = Substract(polynomial1, temp);
                    if (result.terms.size() != 0) {
                        result = Addition(result, monomial);
                    } else {
                        result = monomial;
                    }
                }
            }
        } else {
            result = polynomial1;
        }
        return result;
    }


    public static Polynomial Remainder(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();
        int size1 = polynomial1.maxPower();
        int size2 = polynomial2.maxPower();
        if (size2 == 0 && polynomial2.terms.get(0) == 0) {
            throw new IllegalArgumentException("Cannot divide by zero polynomial");
        }
        int size = size1 - size2;
        if (size2 == 0) {
            double constant = polynomial2.terms.get(0);
            for (int i = 0; i <= size1; i++) {
                result.terms.put(i,polynomial1.getCoefficient(i)/constant);
            }
            polynomial1.terms.clear();
        } else if (size1 >= size2) {
            for (int i = 0; i <= size; i++) {
                Polynomial temp = new Polynomial();
                Integer power1 = polynomial1.maxPower();
                Integer power2 = polynomial2.maxPower();
                Integer power = power1 - power2;
                if (power >= 0) {
                    double coefficient = polynomial1.terms.get(power1) / polynomial2.terms.get(power2);
                    Polynomial monomial = new Polynomial();
                    monomial.terms.put(power, coefficient);
                    temp = Multiply(polynomial2, monomial);
                    polynomial1 = Substract(polynomial1, temp);
                    if (result.terms.size() != 0) {
                        result = Addition(result, monomial);
                    } else {
                        result = monomial;
                    }
                }
            }
        } else {
            result = polynomial1;
        }
        return polynomial1;
    }


}



