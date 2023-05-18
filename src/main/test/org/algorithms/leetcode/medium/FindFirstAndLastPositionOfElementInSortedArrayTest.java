package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindFirstAndLastPositionOfElementInSortedArrayTest {

    FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();


    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(new int[]{1, 6}, new int[]{1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9}, 2))
                .add(Arguments.of(new int[]{0, 1}, new int[]{2, 2}, 2))
                .add(Arguments.of(new int[]{-1, -1}, new int[]{2, 2}, 3))
                .add(Arguments.of(new int[]{0, 0}, new int[]{2}, 2))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(int[] expected, int[] input, int target) {
        int[] result = solution.searchRange(input, target);
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
    }

}