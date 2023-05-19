package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeIntervalsTest {

    MergeIntervals mergeIntervals = new MergeIntervals();


    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(new int[][]{{1, 6}, {8, 10}, {15, 18}}, new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
                .add(Arguments.of(new int[][]{{1, 5}}, new int[][]{{1, 4}, {4, 5}}))
                .add(Arguments.of(new int[][]{{-2, -1}, {0, 6}}, new int[][]{{1, 4}, {-2, -1}, {0, 3}, {4, 6}}))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(int[][] expected, int[][] input) {
        int[][] result = mergeIntervals.merge(input);
        assertArrayEquals(expected, result);
    }


    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int[][] expected, int[][] input) {
        int[][] result = mergeIntervals.mergeV2(input);
        assertArrayEquals(expected, result);
    }

}