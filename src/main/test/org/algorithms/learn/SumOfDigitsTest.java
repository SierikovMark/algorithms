package org.algorithms.learn;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfDigitsTest {

    SumOfDigits sumOfDigits = new SumOfDigits();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(11, 29))
                .add(Arguments.of(11, 29))
                .add(Arguments.of(0, 0))
                .add(Arguments.of(1, 1))
                .add(Arguments.of(3, 12))
                .add(Arguments.of(9, 333))
                .add(Arguments.of(12, 3333))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(int expected, int input) {
        int result = sumOfDigits.sumOfDigits(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int expected, int input) {
        int result = sumOfDigits.sumOfDigitsV2(input);
        assertEquals(expected, result);
    }

}