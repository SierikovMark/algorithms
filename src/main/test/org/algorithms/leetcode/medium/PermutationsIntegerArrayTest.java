package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationsIntegerArrayTest {

    PermutationsIntegerArray permutations = new PermutationsIntegerArray();


    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(List.of(List.of(0, 1, 2), List.of(0, 2, 1), List.of(1, 0, 2), List.of(1, 2, 0), List.of(2, 0, 1), List.of(2, 1, 0)), new int[]{0, 1, 2}))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(List<List<Integer>> expected, int[] input) {
        List<List<Integer>> result = permutations.permute(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(List<List<Integer>> expected, int[] input) {
        List<List<Integer>> result = permutations.permuteV2(input);
        assertEquals(expected, result);
    }

}