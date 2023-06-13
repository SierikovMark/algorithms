package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SetMatrixZeroesTest {

    SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();


    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(
                        new int[][]{
                                {1, 0, 1},
                                {0, 0, 0},
                                {1, 0, 1}
                        },
                        new int[][]{
                                {1, 1, 1},
                                {1, 0, 1},
                                {1, 1, 1}
                        }
                ))
                .add(Arguments.of(
                        new int[][]{
                                {0, 0, 0, 0},
                                {0, 4, 5, 0},
                                {0, 3, 1, 0}
                        },
                        new int[][]{
                                {0, 1, 2, 0},
                                {3, 4, 5, 2},
                                {1, 3, 1, 5}
                        }
                ))
                .add(Arguments.of(
                        new int[][]{
                                {0, 1, 0, 0},
                                {0, 4, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0}
                        },
                        new int[][]{
                                {1, 1, 2, 1},
                                {3, 4, 5, 2},
                                {1, 3, 0, 5},
                                {0, 3, 1, 0}
                        }
                ))
                .add(Arguments.of(
                        new int[][]{
                                {0, 1, 2, 0},
                                {0, 4, 5, 0},
                                {0, 3, 6, 0},
                                {0, 0, 0, 0}
                        },
                        new int[][]{
                                {1, 1, 2, 1},
                                {3, 4, 5, 2},
                                {1, 3, 6, 5},
                                {0, 3, 1, 0}
                        }
                ))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(int[][] expected, int[][] input) {
        setMatrixZeroes.setZeroes(input);
        assertArrayEquals(expected, input);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int[][] expected, int[][] input) {
        setMatrixZeroes.setZeroesV2(input);
        assertArrayEquals(expected, input);
    }

}