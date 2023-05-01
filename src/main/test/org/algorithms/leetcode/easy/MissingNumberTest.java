package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingNumberTest {

    MissingNumber missingNumber = new MissingNumber();


    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(0, new int[]{3, 1, 2}))
                .add(Arguments.of(3, new int[]{2, 0, 1}))
                .add(Arguments.of(2, new int[]{3, 0, 1}))
                .add(Arguments.of(8, new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}))
                .add(Arguments.of(1, new int[]{0, 2}))
                .add(Arguments.of(0, new int[]{}))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test(int expected, int[] testArray) {
        int actualMissingNumber = missingNumber.missingNumber(testArray);
        assertEquals(expected, actualMissingNumber);

    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int expected, int[] testArray) {
        int actualMissingNumber = missingNumber.missingNumberV2(testArray);
        assertEquals(expected, actualMissingNumber);

    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV3(int expected, int[] testArray) {
        int actualMissingNumber = missingNumber.missingNumberV3(testArray);
        assertEquals(expected, actualMissingNumber);

    }

}