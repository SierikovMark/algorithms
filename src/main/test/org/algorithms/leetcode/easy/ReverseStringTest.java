package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseStringTest {

    ReverseString reverseString = new ReverseString();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of("", ""))
                .add(Arguments.of("111", "111"))
                .add(Arguments.of("123", "321"))
                .add(Arguments.of("1234", "4321"))
                .add(Arguments.of("aaa", "aaa"))
                .add(Arguments.of("abb", "bba"))
                .add(Arguments.of("abc", "cba"))
                .add(Arguments.of("abcd", "dcba"))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV1(String expected, String input) {
        char[] inputCharArray = input.toCharArray();
        reverseString.reverseString(inputCharArray);
        assertEquals(expected, new String(inputCharArray));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(String expected, String input) {
        char[] inputCharArray = input.toCharArray();
        reverseString.reverseStringV2(inputCharArray);
        assertEquals(expected, new String(inputCharArray));
    }

}