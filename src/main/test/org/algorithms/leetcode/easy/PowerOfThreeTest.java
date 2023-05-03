package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfThreeTest {

    PowerOfThree powerOfThree = new PowerOfThree();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(true, 27))
                .add(Arguments.of(false, 0))
                .add(Arguments.of(false, -1))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test(boolean expected, int input) {
        boolean isPowerOfTree = powerOfThree.isPowerOfThree(input);
        assertEquals(expected, isPowerOfTree);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(boolean expected, int input) {
        boolean isPowerOfTree = powerOfThree.isPowerOfThreeV2(input);
        assertEquals(expected, isPowerOfTree);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV3(boolean expected, int input) {
        boolean isPowerOfTree = powerOfThree.isPowerOfThreeV3(input);
        assertEquals(expected, isPowerOfTree);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV4(boolean expected, int input) {
        boolean isPowerOfTree = powerOfThree.isPowerOfThreeV4(input);
        assertEquals(expected, isPowerOfTree);
    }

}