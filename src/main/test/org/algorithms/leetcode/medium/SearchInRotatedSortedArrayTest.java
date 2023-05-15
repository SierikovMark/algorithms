package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInRotatedSortedArrayTest {

    SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(1, new int[] {1, 3}, 3))
                .add(Arguments.of(1, new int[] {3, 1}, 1))
                .add(Arguments.of(-1, new int[] {3, 1}, 2))
                .add(Arguments.of(-1, new int[] {1, 3}, 0))
                .add(Arguments.of(4, new int[] {4,5,6,7,0,1,2}, 0))
                .add(Arguments.of(-1, new int[] {4,5,6,7,0,1,2}, 3))
                .add(Arguments.of(4, new int[] {4,5,6,7,8,1,2,3}, 8))
                .add(Arguments.of(-1, new int[] {1}, 0))
                .add(Arguments.of(0, new int[] {1}, 1))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV1(int expected, int[] input, int target) {
        int result = searchInRotatedSortedArray.search(input, target);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int expected, int[] input, int target) {
        int result = searchInRotatedSortedArray.searchV2(input, target);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV3(int expected, int[] input, int target) {
        int result = searchInRotatedSortedArray.searchV3(input, target);
        assertEquals(expected, result);
    }

}