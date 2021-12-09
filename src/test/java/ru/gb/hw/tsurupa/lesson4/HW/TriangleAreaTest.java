package ru.gb.hw.tsurupa.lesson4.HW;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {
    @ParameterizedTest
    @DisplayName("Позитивная проверка")
    @CsvSource({"3, 4, 5, 6", "4, 5, 6, 9.92", "5, 6, 7, 14.70"})
    void triangleArea(double a, double b, double c, double result) {
        Assertions.assertEquals(result, TriangleArea.triangleArea(a, b, c));
    }

    @ParameterizedTest
    @DisplayName("Негативная проверка с отрицательными значениями стороны треугольника")
    @CsvSource({"-3, 4, 5"})
    void catchExceptionNegativeSide(double a, double b, double c) {
       IllegalArgumentException exceptionNegativeSide = assertThrows(IllegalArgumentException.class,
               () -> TriangleArea.triangleArea(a, b, c));
       assertEquals("The sides must be positive!", exceptionNegativeSide.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Негативная проверка с несуществующим треугольников")
    @CsvSource({"1, 2, 3"})
    void catchExceptionNotExistTriangle(double a, double b, double c) {
        IllegalArgumentException exceptionNegativeSide = assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.triangleArea(a, b, c));
        assertEquals("The triangle with such countries does not exist", exceptionNegativeSide.getMessage());
    }

}
