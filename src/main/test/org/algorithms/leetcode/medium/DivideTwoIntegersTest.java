package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideTwoIntegersTest {

    DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(-1, -1, 1))
                .add(Arguments.of(3, 10, 3))
                .add(Arguments.of(-2, 7, -3))
                .add(Arguments.of(1, -2147483648, -2147483647))
                .add(Arguments.of(2147483647, 2147483647, 1))
                .add(Arguments.of(7, 42, 6))
                .add(Arguments.of(-2147483648, -2147483648, 1))
                .add(Arguments.of(1, -2147483648, -2147483648))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void testV1(int expected, int dividend, int divisor) {
        int result = divideTwoIntegers.divide(dividend, divisor);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int expected, int dividend, int divisor) {
        int result = divideTwoIntegers.divideV2(dividend, divisor);
        assertEquals(expected, result);
    }


    @ParameterizedTest
    @MethodSource("testData")
    void testV3(int expected, int dividend, int divisor) {
        int result = divideTwoIntegers.divideV3(dividend, divisor);
        assertEquals(expected, result);
    }

}