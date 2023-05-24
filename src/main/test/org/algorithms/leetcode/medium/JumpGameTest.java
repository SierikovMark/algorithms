package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGameTest {

    JumpGame jumpGame = new JumpGame();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(true, new int[]{2, 5, 0, 0}))
                .add(Arguments.of(false, new int[]{2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6}))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test(boolean expected, int[] input) {
        boolean canJump = jumpGame.canJump(input);
        assertEquals(expected, canJump);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(boolean expected, int[] input) {
        boolean canJump = jumpGame.canJumpV2(input);
        assertEquals(expected, canJump);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV3(boolean expected, int[] input) {
        boolean canJump = jumpGame.canJumpV3(input);
        assertEquals(expected, canJump);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV4(boolean expected, int[] input) {
        boolean canJump = jumpGame.canJumpV4(input);
        assertEquals(expected, canJump);
    }

}