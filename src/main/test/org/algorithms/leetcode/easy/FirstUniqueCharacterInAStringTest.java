package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueCharacterInAStringTest {

    FirstUniqueCharacterInAString uniqueCharacterInAString = new FirstUniqueCharacterInAString();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(-1, null))
                .add(Arguments.of(-1, ""))
                .add(Arguments.of(0, "e"))
                .add(Arguments.of(-1, "dd"))
                .add(Arguments.of(2, "dde"))
                .add(Arguments.of(0, "dee"))
                .add(Arguments.of(-1, "ddee"))
                .add(Arguments.of(3, "dddreee"))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV1(int expectedIndex, String input) {
        int firstUniqChar = uniqueCharacterInAString.firstUniqChar(input);
        assertEquals(expectedIndex, firstUniqChar);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(int expectedIndex, String input) {
        int firstUniqChar = uniqueCharacterInAString.firstUniqCharV2(input);
        assertEquals(expectedIndex, firstUniqChar);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV3(int expectedIndex, String input) {
        int firstUniqChar = uniqueCharacterInAString.firstUniqCharV3(input);
        assertEquals(expectedIndex, firstUniqChar);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV4(int expectedIndex, String input) {
        int firstUniqChar = uniqueCharacterInAString.firstUniqCharV4(input);
        assertEquals(expectedIndex, firstUniqChar);
    }
}