package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortColorsTest {

    SortColors sortColors = new SortColors();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(
                        new int[]{0, 0, 1, 1, 2, 2},
                        new int[]{2, 0, 2, 1, 1, 0}
                ))
                .add(Arguments.of(
                        new int[]{0, 1, 2},
                        new int[]{2, 0, 1}
                ))
                .add(Arguments.of(
                        new int[]{0},
                        new int[]{0}
                ))
                .add(Arguments.of(
                        new int[]{1},
                        new int[]{1}
                ))
                .add(Arguments.of(
                        new int[]{2},
                        new int[]{2}
                ))
                .add(Arguments.of(
                        new int[]{0, 0, 1, 1, 2, 2},
                        new int[]{0, 0, 1, 1, 2, 2}
                ))
                .add(Arguments.of(
                        new int[]{0, 0, 1, 1, 2, 2},
                        new int[]{2, 2, 1, 1, 0, 0}
                ))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(int[] expected, int[] input) {
        sortColors.sortColors(input);
        assertArrayEquals(expected, input);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int[] expected, int[] input) {
        sortColors.sortColorsV2(input);
        assertArrayEquals(expected, input);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV3(int[] expected, int[] input) {
        sortColors.sortColorsV3(input);
        assertArrayEquals(expected, input);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV4(int[] expected, int[] input) {
        sortColors.sortColorsV4(input);
        assertArrayEquals(expected, input);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV5(int[] expected, int[] input) {
        sortColors.sortColorsV5(input);
        assertArrayEquals(expected, input);
    }

}