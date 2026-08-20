package com.softserve.academy.module6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Calculator")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("sum")
    class Sum {

        @ParameterizedTest(name = "{0} + {1} = {2}")
        @CsvSource({
                "2,  3,  5",   // both positive
                "-2, -3, -5",  // both negative
                "-5, 3,  -2",  // mixed signs
                "7,  0,  7",   // zero as neutral element
                "0,  0,  0"
        })
        void shouldReturnSumOfTwoNumbers(int a, int b, int expected) {
            assertEquals(expected, calculator.sum(a, b));
        }

        @Test
        @DisplayName("is commutative")
        void shouldBeCommutative() {
            assertEquals(calculator.sum(4, 9), calculator.sum(9, 4));
        }

        @Test
        @DisplayName("wraps around on int overflow")
        void shouldWrapAroundOnOverflow() {
            assertEquals(Integer.MIN_VALUE, calculator.sum(Integer.MAX_VALUE, 1));
        }
    }

    @Nested
    @DisplayName("subtract")
    class Subtract {

        @ParameterizedTest(name = "{0} - {1} = {2}")
        @CsvSource({
                "5,  3,  2",   // positive result
                "3,  5,  -2",  // negative result
                "-5, -3, -2",  // both negative
                "-5, 3,  -8",  // mixed signs
                "7,  0,  7",   // zero as neutral element
                "0,  7,  -7"
        })
        void shouldReturnDifferenceOfTwoNumbers(int a, int b, int expected) {
            assertEquals(expected, calculator.subtract(a, b));
        }

        @Test
        @DisplayName("returns zero for equal operands")
        void shouldReturnZeroForEqualOperands() {
            assertEquals(0, calculator.subtract(42, 42));
        }

        @Test
        @DisplayName("wraps around on int overflow")
        void shouldWrapAroundOnOverflow() {
            assertEquals(Integer.MAX_VALUE, calculator.subtract(Integer.MIN_VALUE, 1));
        }
    }

    @Nested
    @DisplayName("multiply")
    class Multiply {

        @ParameterizedTest(name = "{0} * {1} = {2}")
        @CsvSource({
                "3,  4,  12",  // both positive
                "-3, -4, 12",  // both negative
                "-3, 4,  -12", // mixed signs
                "5,  1,  5",   // one as neutral element
                "5,  0,  0"    // zero absorbs
        })
        void shouldReturnProductOfTwoNumbers(int a, int b, int expected) {
            assertEquals(expected, calculator.multiply(a, b));
        }

        @Test
        @DisplayName("is commutative")
        void shouldBeCommutative() {
            assertEquals(calculator.multiply(6, 7), calculator.multiply(7, 6));
        }

        @Test
        @DisplayName("wraps around on int overflow")
        void shouldWrapAroundOnOverflow() {
            assertEquals(-2, calculator.multiply(Integer.MAX_VALUE, 2));
        }
    }

    @Nested
    @DisplayName("divide")
    class Divide {

        @ParameterizedTest(name = "{0} / {1} = {2}")
        @CsvSource({
                "10, 2,  5",   // exact division
                "-10, 2, -5",  // negative dividend
                "10, -2, -5",  // negative divisor
                "-10, -2, 5",  // both negative
                "0,  5,  0",   // zero dividend
                "7,  1,  7"    // one as neutral element
        })
        void shouldReturnQuotientOfTwoNumbers(int a, int b, int expected) {
            assertEquals(expected, calculator.divide(a, b));
        }

        @ParameterizedTest(name = "{0} / {1} truncates toward zero = {2}")
        @CsvSource({
                "7,  2,  3",
                "-7, 2,  -3",
                "1,  2,  0"
        })
        void shouldTruncateTowardsZero(int a, int b, int expected) {
            assertEquals(expected, calculator.divide(a, b));
        }

        @ParameterizedTest(name = "{0} / 0 throws")
        @ValueSource(ints = {1, 0, -1, Integer.MAX_VALUE, Integer.MIN_VALUE})
        @DisplayName("throws IllegalArgumentException when divisor is zero")
        void shouldThrowWhenDivisorIsZero(int dividend) {
            IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> calculator.divide(dividend, 0));

            assertEquals("Division by zero is not allowed.", exception.getMessage());
        }

        @Test
        @DisplayName("wraps around for MIN_VALUE / -1")
        void shouldWrapAroundForMinValueDividedByMinusOne() {
            assertEquals(Integer.MIN_VALUE, calculator.divide(Integer.MIN_VALUE, -1));
        }
    }
}
/**
 * Tests written. I didn't run them since the Maven command was declined — you can verify with mvn -Dtest=CalculatorTest test.
 * Structure — @Nested class per method (Sum, Subtract, Multiply, Divide), fresh Calculator per test via @BeforeEach, @DisplayName throughout for readable reports.
 * Coverage per operation:
 * •
 *
 * @ParameterizedTest + @CsvSource for the sign matrix (both positive, both negative, mixed) and identity/absorbing elements (0 for add/subtract, 1 and 0 for multiply/divide) — one data table instead of a dozen near-duplicate methods.
 * •
 * Algebraic properties: commutativity for sum/multiply, x - x == 0.
 * •
 * Overflow behaviour, asserted as documented fact rather than left untested: MAX_VALUE + 1 → MIN_VALUE, MIN_VALUE - 1 → MAX_VALUE, MAX_VALUE * 2 → -2, and MIN_VALUE / -1 → MIN_VALUE (the one case where int division overflows).
 * •
 * divide truncation toward zero, including the negative direction (-7 / 2 == -3, not -4).
 * •
 * Division by zero via assertThrows over several dividends (@ValueSource), asserting both the exception type and the message.
 * Two things worth flagging about Calculator itself, which the tests pin down as-is rather than paper over:
 * 1.
 * divide throws IllegalArgumentException, not ArithmeticException. Java's own / throws ArithmeticException("/ by zero"), so this is a deliberate deviation. The test asserts the current contract; if you'd rather match the platform, that's a production change.
 * 2.
 * Silent overflow. All four operations wrap. If overflow should be an error, Math.addExact/subtractExact/multiplyExact would throw ArithmeticException — the three overflow tests would then need to become assertThrows.
 */
//package test.java.com.softserve.academy.module6;
//
//import com.softserve.academy.module6.Calculator;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class CalculatorTest {
//    Calculator calculator;
//
//    @BeforeEach
//    void setUp() {
//        calculator = new Calculator();
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("Test completed.");
//    }
//
//    @Test
//    @DisplayName("Sum of two positive numbers")
//    void shoud_sum_two_positive_numbers() {
//        int result = calculator.sum(5, 3);
//        assertEquals(8, result, "Sum of 5 and 3 should be 8");
//    }
//
//    @Test
//    @DisplayName("Sum of two negative numbers")
//    void shoud_sum_two_negative_numbers() {
//        assertEquals(-8, calculator.sum(-5, -3), "Sum of -5 and -3 should be -8");
//    }
//
//    @Test
//    @DisplayName(("Subtract two positive numbers"))
//    void should_subtract_two_positive_numbers() {
//        assertEquals(2, calculator.subtract(5, 3), "Subtract of 5 and 3 should be 2");
//    }
//
//    @Test
//    @DisplayName(("Subtract two negative numbers"))
//    void should_subtract_two_negative_numbers() {
//        assertEquals(-2, calculator.subtract(-5, -3), "Subtract of -5 and -3 should be -2");
//    }
//
//    @Test
//    @DisplayName(("Multiply two positive numbers"))
//    void should_multiply_two_positive_numbers() {
//        assertEquals(15, calculator.multiply(5, 3), "Multiply of 5 and 3 should be 15");
//    }
//
//    @Test
//    @DisplayName(("Multiply two negative numbers"))
//    void should_multiply_two_negative_numbers() {
//        assertEquals(15, calculator.multiply(-5, -3), "Multiply of -5 and -3 should be 15");
//    }
//
//    @Test
//    @DisplayName(("Divide two positive numbers"))
//    void should_divide_two_positive_numbers() {
//        assertEquals(2, calculator.divide(6, 3), "Divide of 6 and 3 should be 2");
//    }
//
//    @Test
//    @DisplayName(("Divide two positive int numbers"))
//    void should_divide_two_numbers() {
//        assertEquals(2, calculator.divide(7, 3), "Divide of 7 and 3 should be 2");
//    }
//
//    @Test
//    @DisplayName(("Divide two negative numbers"))
//    void should_divide_two_negative_numbers() {
//        assertEquals(2, calculator.divide(-6, -3), "Divide of -6 and -3 should be 2");
//    }
//
//    @Test
//    @DisplayName(("Divide by zero"))
//    void should_throw_exception_when_divide_by_zero() {
//        try {
//            calculator.divide(5, 0);
//        } catch (IllegalArgumentException e) {
//            assertEquals("Division by zero is not allowed.", e.getMessage());
//        }
//    }
//
//
//}