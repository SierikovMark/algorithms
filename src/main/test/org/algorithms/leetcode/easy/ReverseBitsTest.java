package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseBitsTest {

    ReverseBits reverseBits = new ReverseBits();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(43261596, 964176192))
                .add(Arguments.of(-2, 2147483647))
                .build();
    }

    @MethodSource("testData")
    @ParameterizedTest
    void test(int input, int expectedValue) {
        int numberFromReversedBits = reverseBits.reverseBits(input);
        assertEquals(expectedValue, numberFromReversedBits);
    }

}