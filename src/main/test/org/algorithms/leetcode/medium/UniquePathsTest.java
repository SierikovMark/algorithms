package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsTest {

    UniquePaths uniquePaths = new UniquePaths();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(28, 3, 7))
                .add(Arguments.of(3, 3, 2))
                .add(Arguments.of(1, 1, 1))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test(int expected, int m, int n) {
        int result = uniquePaths.uniquePaths(m, n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int expected, int m, int n) {
        int result = uniquePaths.uniquePathsV2(m, n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV3(int expected, int m, int n) {
        int result = uniquePaths.uniquePathsV3(m, n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV4(int expected, int m, int n) {
        int result = uniquePaths.uniquePathsV4(m, n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV5(int expected, int m, int n) {
        int result = uniquePaths.uniquePathsV5(m, n);
        assertEquals(expected, result);
    }
}
