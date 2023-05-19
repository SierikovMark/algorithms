package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateImageTest {

    RotateImage rotateImage = new RotateImage();


    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(
                        new int[][]{
                                {3, 1},
                                {4, 2},
                        },
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        }
                ))
                .add(Arguments.of(
                        new int[][]{
                                {7, 4, 1},
                                {8, 5, 2},
                                {9, 6, 3}
                        },
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        }
                ))
                .add(Arguments.of(
                        new int[][]{
                                {13, 9, 5, 1},
                                {14, 10, 6, 2},
                                {15, 11, 7, 3},
                                {16, 12, 8, 4}
                        },
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16},
                        }
                ))
                .add(Arguments.of(
                        new int[][]{
                                {15, 13, 2, 5},
                                {14, 3, 4, 1},
                                {12, 6, 8, 9},
                                {16, 7, 10, 11}
                        },
                        new int[][]{
                                {5, 1, 9, 11},
                                {2, 4, 8, 10},
                                {13, 3, 6, 7},
                                {15, 14, 12, 16}
                        }
                ))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(int[][] expected, int[][] input) {
        rotateImage.rotate(input);
        assertArrayEquals(expected, input);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int[][] expected, int[][] input) {
        rotateImage.rotateV2(input);
        assertArrayEquals(expected, input);
    }

}