package test.java.com.softserve.academy.module6;

import com.softserve.academy.module6.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed.");
    }

    @Test
    @DisplayName("Sum of two positive numbers")
    void shoud_sum_two_positive_numbers() {
        int result = calculator.sum(5, 3);
        assertEquals(8, result, "Sum of 5 and 3 should be 8");
    }

    @Test
    @DisplayName("Sum of two negative numbers")
    void shoud_sum_two_negative_numbers() {
        assertEquals(-8, calculator.sum(-5, -3), "Sum of -5 and -3 should be -8");
    }

    @Test
    @DisplayName(("Subtract two positive numbers"))
    void should_subtract_two_positive_numbers() {
        assertEquals(2, calculator.subtract(5, 3), "Subtract of 5 and 3 should be 2");
    }

    @Test
    @DisplayName(("Subtract two negative numbers"))
    void should_subtract_two_negative_numbers() {
        assertEquals(-2, calculator.subtract(-5, -3), "Subtract of -5 and -3 should be -2");
    }

    @Test
    @DisplayName(("Multiply two positive numbers"))
    void should_multiply_two_positive_numbers() {
        assertEquals(15, calculator.multiply(5, 3), "Multiply of 5 and 3 should be 15");
    }

    @Test
    @DisplayName(("Multiply two negative numbers"))
    void should_multiply_two_negative_numbers() {
        assertEquals(15, calculator.multiply(-5, -3), "Multiply of -5 and -3 should be 15");
    }

    @Test
    @DisplayName(("Divide two positive numbers"))
    void should_divide_two_positive_numbers() {
        assertEquals(2, calculator.divide(6, 3), "Divide of 6 and 3 should be 2");
    }

    @Test
    @DisplayName(("Divide two positive int numbers"))
    void should_divide_two_numbers() {
        assertEquals(2, calculator.divide(7, 3), "Divide of 7 and 3 should be 2");
    }

    @Test
    @DisplayName(("Divide two negative numbers"))
    void should_divide_two_negative_numbers() {
        assertEquals(2, calculator.divide(-6, -3), "Divide of -6 and -3 should be 2");
    }

    @Test
    @DisplayName(("Divide by zero"))
    void should_throw_exception_when_divide_by_zero() {
        try {
            calculator.divide(5, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }


}