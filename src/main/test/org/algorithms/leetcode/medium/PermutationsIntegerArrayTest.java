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
        long start = System.currentTimeMillis();
        List<List<Integer>> result = null;
        for (int i = 0; i < 1000; i++) {
            result = permutations.permute(input);
        }
        System.out.println("V1 = " + (System.currentTimeMillis() - start));
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(List<List<Integer>> expected, int[] input) {
        long start = System.currentTimeMillis();
        List<List<Integer>> result = null;
        for (int i = 0; i < 1000; i++) {
            result = permutations.permuteV2(input);
        }
        System.out.println("V2 = " + (System.currentTimeMillis() - start));
        assertEquals(expected, result);
    }

}