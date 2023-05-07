package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    ThreeSum threeSum = new ThreeSum();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(
                        List.of(
                                List.of(-1, -1, 2),
                                List.of(-1, 0, 1)
                        ), new int[]{-1, 0, 1, 2, -1, -4}))
                .add(Arguments.of(
                        List.of(), new int[]{0, 1, 1}))
                .add(Arguments.of(
                        List.of(
                                List.of(0, 0, 0)
                        ), new int[]{0, 0, 0}))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV1(List<List<Integer>> expected, int[] input) {
        List<List<Integer>> result = threeSum.threeSum(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(List<List<Integer>> expected, int[] input) {
        List<List<Integer>> result = threeSum.threeSumV2(input);
        assertEquals(expected, result);
    }

}