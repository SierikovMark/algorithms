package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToIntegerAtoiTest {

    StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(-2147483648, "-91283472332"))
                .add(Arguments.of(2147483647, "2147483647"))
                .add(Arguments.of(-2147483648, "-2147483648"))
                .add(Arguments.of(0, "-+1"))
                .add(Arguments.of(1, "+1"))
                .add(Arguments.of(-5, "-5-"))
                .add(Arguments.of(0, "00000-42a1234"))
                .add(Arguments.of(-42, "-0042"))
                .add(Arguments.of(-1, "-1"))
                .add(Arguments.of(0, ""))
                .add(Arguments.of(0, " "))
                .add(Arguments.of(0, "-"))
                .add(Arguments.of(0, "+"))
                .add(Arguments.of(0, "+"))
                .add(Arguments.of(4193, "4193 with words"))
                .add(Arguments.of(-42, "   -42"))
                .add(Arguments.of(0, " +-"))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void testV1(int expected, String input) {
        int result = stringToIntegerAtoi.myAtoi(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int expected, String input) {
        int result = stringToIntegerAtoi.myAtoiV2(input);
        assertEquals(expected, result);
    }

}