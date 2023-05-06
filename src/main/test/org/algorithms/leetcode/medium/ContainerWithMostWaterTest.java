package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {

    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(49, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}))
                .add(Arguments.of(1, new int[]{1, 1}))
                .add(Arguments.of(0, new int[]{}))
                .add(Arguments.of(0, new int[]{15}))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void testV1(int expected, int[] input) {
        int maxArea = containerWithMostWater.maxArea(input);
        assertEquals(expected, maxArea);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int expected, int[] input) {
        int maxArea = containerWithMostWater.maxAreaV2(input);
        assertEquals(expected, maxArea);
    }
}