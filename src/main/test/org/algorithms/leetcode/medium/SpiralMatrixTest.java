package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralMatrixTest {

    SpiralMatrix spiralMatrix = new SpiralMatrix();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(
                        List.of(6, 3),
                        new int[][]{
                                {6},
                                {3}
                        }
                ))
                .add(Arguments.of(
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5),
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        }
                ))
                .add(Arguments.of(
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}
                        }
                ))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(List<Integer> expected, int[][] input) {
        List<Integer> result = spiralMatrix.spiralOrder(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(List<Integer> expected, int[][] input) {
        List<Integer> result = spiralMatrix.spiralOrderV2(input);
        assertEquals(expected, result);
    }

}