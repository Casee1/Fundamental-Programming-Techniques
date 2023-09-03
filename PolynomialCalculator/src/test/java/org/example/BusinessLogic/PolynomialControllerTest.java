package org.example.BusinessLogic;

import junit.framework.TestCase;
import org.example.Model.Polynomial;

public class PolynomialControllerTest extends TestCase {

    public void testDerivate() {
        Polynomial polynomial = new Polynomial();
        Polynomial result = new Polynomial();
        polynomial.terms.put(4, 1.0);
        polynomial.terms.put(2, 4.0);
        polynomial.terms.put(1, 2.0);
        polynomial.terms.put(0, 10.0);
        result = PolynomialController.Derivate(polynomial);
        assertEquals("2.0 + 8.0*x^1 + 4.0*x^3", result.toString());
    }

    public void testIntegration() {
        Polynomial polynomial = new Polynomial();
        Polynomial result = new Polynomial();
        polynomial.terms.put(4, 1.0);
        polynomial.terms.put(2, 4.0);
        polynomial.terms.put(1, 2.0);
        polynomial.terms.put(0, 10.0);
        result = PolynomialController.Integration(polynomial);
        assertEquals("10.0*x^1 + 1.0*x^2 + 1.3333333333333333*x^3 + 0.2*x^5", result.toString());
    }

    public void testAddition() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Polynomial result = new Polynomial();
        polynomial1.terms.put(2, 4.0);
        polynomial2.terms.put(3, 5.0);
        polynomial1.terms.put(1, 3.0);
        polynomial2.terms.put(1, 6.0);
        polynomial1.terms.put(0, 10.0);
        polynomial2.terms.put(0, 12.0);
        result = PolynomialController.Addition(polynomial1, polynomial2);
        assertEquals("22.0 + 9.0*x^1 + 4.0*x^2 + 5.0*x^3", result.toString());
    }

    public void testSubstract() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Polynomial result = new Polynomial();
        polynomial1.terms.put(2, 4.0);
        polynomial2.terms.put(3, 5.0);
        polynomial1.terms.put(1, 3.0);
        polynomial2.terms.put(1, 6.0);
        polynomial1.terms.put(0, 10.0);
        polynomial2.terms.put(0, 12.0);
        result = PolynomialController.Substract(polynomial1, polynomial2);
        assertEquals("-2.0 - 3.0*x^1 + 4.0*x^2 - 5.0*x^3", result.toString());
    }

    public void testMultiply() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Polynomial result = new Polynomial();
        polynomial1.terms.put(2, 4.0);
        polynomial2.terms.put(3, 5.0);
        polynomial1.terms.put(1, 3.0);
        polynomial2.terms.put(1, 6.0);
        polynomial1.terms.put(0, 10.0);
        polynomial2.terms.put(0, 12.0);
        result = PolynomialController.Multiply(polynomial1, polynomial2);
        assertEquals("120.0 + 96.0*x^1 + 66.0*x^2 + 74.0*x^3 + 15.0*x^4 + 20.0*x^5", result.toString());
    }

    public void testDivision() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Polynomial result = new Polynomial();
        polynomial1.terms.put(2, 3.0);
        polynomial1.terms.put(1, 2.0);
        polynomial2.terms.put(1, 1.0);
        polynomial2.terms.put(0, 1.0);
        result = PolynomialController.Division(polynomial1, polynomial2);
        assertEquals("-1.0 + 3.0*x^1", result.toString());
    }

    public void testRemainder() {
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        Polynomial result = new Polynomial();
        polynomial1.terms.put(2, 3.0);
        polynomial1.terms.put(1, 2.0);
        polynomial2.terms.put(1, 1.0);
        polynomial2.terms.put(0, 1.0);
        result = PolynomialController.Remainder(polynomial1, polynomial2);
        assertEquals("1.0", result.toString());

    }
}