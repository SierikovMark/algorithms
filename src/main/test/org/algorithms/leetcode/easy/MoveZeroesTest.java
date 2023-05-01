package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {

    MoveZeroes moveZeroes = new MoveZeroes();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(new int[]{3, 4, 1, 0, 0}, new int[]{0, 3, 4, 1, 0}))
                .add(Arguments.of(new int[]{3, 4, 1, 0, 0}, new int[]{0, 3, 4, 0, 1}))
                .add(Arguments.of(new int[]{3, 4, 1, 0, 0}, new int[]{0, 0, 3, 4, 1}))
                .add(Arguments.of(new int[]{0, 0, 0}, new int[]{0, 0, 0}))
                .add(Arguments.of(new int[]{0}, new int[]{0}))
                .add(Arguments.of(new int[]{}, new int[]{}))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test(int[] expected, int[] input) {
        moveZeroes.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int[] expected, int[] input) {
        moveZeroes.moveZeroesV2(input);
        assertArrayEquals(expected, input);
    }

}