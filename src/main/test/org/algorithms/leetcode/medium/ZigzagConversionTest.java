package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigzagConversionTest {
    private final ZigzagConversion zigzagConversion = new ZigzagConversion();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of("PAHNAPLSIIGYIR", "PAYPALISHIRING", 3))
                .add(Arguments.of("PINALSIGYAHRPI", "PAYPALISHIRING", 4))
                .add(Arguments.of("A", "A", 1))
                .add(Arguments.of("ABBD", "ABBD", 1))
                .add(Arguments.of("RULE", "RULE", 4))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test(String expected, String input, int numRows) {
        String result = zigzagConversion.convert(input, numRows);
        assertEquals(expected, result);
    }

}