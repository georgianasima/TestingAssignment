package org.example;

import java.util.Arrays;
import java.util.List;

public class DistanceCalculator {
    public static int computeDistance(String expression, String outputUnit) {
        // Convert expression to a list of terms
        List<String> terms=Arrays.asList(expression.split("\\s*[-+]\\s*"));

        // Compute the total value in millimeters
        int total = 0;
        for (String term :terms) {
            int value = Integer.parseInt(term.replaceAll("[^0-9]", ""));
            String unit = term.replaceAll("[^a-z]", "");
            switch (unit) {
                case "mm":
                    total += value;
                    break;
                case "cm":
                    total += value * 10;
                    break;
                case "dm":
                    total += value * 100;
                    break;
                case "m":
                    total += value * 1000;
                    break;
                case "km":
                    total += value * 1000000;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid unit: " + unit);
            }
        }
        switch (outputUnit) {
            case "mm":
                return total;
            case "cm":
                return total / 10;
            case "dm":
                return total / 100;
            case "m":
                return total / 1000;
            case "km":
                return total / 1000000;
            default:
                throw new IllegalArgumentException("Invalid unit: " + outputUnit);
        }
    }
}
