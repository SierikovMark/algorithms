package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowXNTest {

    PowXN powXN = new PowXN();


    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(8.0, 2.0, 3))
                .add(Arguments.of(1024.0, 2.00000, 10))
                .add(Arguments.of(9.261, 2.10000, 3))
                .add(Arguments.of(0.25, 2.00000, -2))
                .add(Arguments.of(0.0, 0.00001, 2147483647))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(double expected, double number, int pow) {
        double result = powXN.myPow(number, pow);
        assertEquals(expected, result, 0.00001);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(double expected, double number, int pow) {
        double result = powXN.myPowV2(number, pow);
        assertEquals(expected, result, 0.00001);
    }

}