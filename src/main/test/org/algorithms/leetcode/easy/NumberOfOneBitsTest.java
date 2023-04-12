package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfOneBitsTest {

    NumberOfOneBits numberOfOneBits = new NumberOfOneBits();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(11, 3))
                .add(Arguments.of(1, 1))
                .add(Arguments.of(0, 0))
                .add(Arguments.of(3, 2))
                .add(Arguments.of(3, 2))
                .add(Arguments.of(10, 2))
                .add(Arguments.of(16, 1))
                .build();
    }

    @MethodSource("testData")
    @ParameterizedTest
    void test(int input, int expectedAmount) {
        int amountOfOneBits = numberOfOneBits.hammingWeight(input);
        assertEquals(expectedAmount, amountOfOneBits);
    }

}