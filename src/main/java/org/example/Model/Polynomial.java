package org.example.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    public Map<Integer, Double> terms;

    public Polynomial() {
        this.terms = new HashMap<>();
    }

    public static int Position(String string) {
        int i = 0;
        for (char c : string.toCharArray()) {
            if (c == 'x') {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void BuildPolynomial(String string) {
        String[] words = string.split("\\s");
        double sign = 1;
        for (String i : words) {
            if (i.equals("+")) {
                sign = 1;
            } else if (i.equals("-")) {
                sign = -1;
            } else {
                int position = Position(i);
                if (position == 0) {
                    String power = i.substring(1);
                    this.terms.put(Integer.parseInt(power), sign);
                } else if (position == -1) {
                    this.terms.put(0, sign * Double.parseDouble(i));
                } else {
                    String coefficient = i.substring(0, position);
                    String power = i.substring(position + 1);
                    this.terms.put(Integer.parseInt(power), sign * Double.parseDouble(coefficient));
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Double> entry : this.terms.entrySet()) {
            if (entry.getValue() != 0) {
                double coefficient = entry.getValue();
                if (sb.length() > 0) {
                    sb.append(coefficient >= 0 ? " + " : " - ");
                }
                double absValue = Math.abs(coefficient);
                if (entry.getKey() == 0) {
                    sb.append(entry.getValue());
                } else {
                    sb.append(absValue).append("*x^").append(entry.getKey());
                }
            }
        }
        return sb.toString();
    }


    public Set<Integer> getExponents() {
        return terms.keySet();
    }

    public double getCoefficient(int exponent) {
        Double coefficient = terms.get(exponent);
        return coefficient != null ? coefficient : 0.0;
    }

    public void setTerms(double coefficient, int exponent) {
        if (coefficient == 0.0) {
            terms.remove(exponent);
        } else {
            terms.put(exponent, coefficient);
        }
    }

    public int maxPower() {
        Set<Integer> exponents = getExponents();
        int max = 0;
        for (int exponent : exponents) {
            if (terms.get(exponent) != 0 && exponent > max) {
                max = exponent;
            }
        }
        return max;
    }


    public boolean onlyZero() {
        return terms.values().stream().allMatch(value -> value == 0);
    }

}

