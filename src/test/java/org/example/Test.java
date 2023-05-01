package org.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DistanceCalculatorTest {
    @Nested
    @DisplayName("computeDistance method")
    class ComputeDistanceTests {
        @Test
        @DisplayName("should return the value in millimeters for an expression in millimeters")
        void testComputeDistanceWithExpressionInMillimeters() {
            int result = DistanceCalculator.computeDistance("10 mm", "mm");
            assertEquals(10, result);
        }

        @Test
        @DisplayName("should return the value in millimeters for an expression in centimeters")
        void testComputeDistanceWithExpressionInCentimeters() {
            int result = DistanceCalculator.computeDistance("10 cm", "mm");
            assertEquals(100, result);
        }
        @Test
        @DisplayName("should return the value in millimeters for an expression in decimeters")
        void testComputeDistanceWithExpressionInDecimeters() {
            int result = DistanceCalculator.computeDistance("10 dm", "mm");
            assertEquals(1000, result);
        }
        @Test
        @DisplayName("should return the value in millimeters for an expression in meters")
        void testComputeDistanceWithExpressionInMeters() {
            int result = DistanceCalculator.computeDistance("10 m", "mm");
            assertEquals(10000, result);
        }
        @Test
        @DisplayName("should return the value in millimeters for an expression in kilometers")
        void testComputeDistanceWithExpressionInKilometers() {
            int result = DistanceCalculator.computeDistance("10 km", "mm");
            assertEquals(10000000, result);
        }
        @DisplayName("should handle complex expressions with different units")
        void testComputeDistanceWithComplexExpressions(String expression, String outputUnit, int expected) {
            int result = DistanceCalculator.computeDistance(expression, outputUnit);
            assertEquals(expected, result);
        }

    }

}
