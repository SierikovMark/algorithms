package org.algorithms.learn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayPalindromeTest {

    ArrayPalindrome arrayPalindrome = new ArrayPalindrome();


    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(true, new String[]{"aa", "bab", "cde", "aba", "ab"}))
                .add(Arguments.of(true, new String[]{"aa"}))
                .add(Arguments.of(true, new String[]{"aa", "aa"}))
                .add(Arguments.of(true, new String[]{"a", "bab"}))
                .add(Arguments.of(true, new String[]{"aba", "b"}))
                .add(Arguments.of(true, new String[]{"aba", "a", "ba"}))
                .add(Arguments.of(true, new String[]{"aba", "a", "b", "aa", "ba"}))
                .add(Arguments.of(true, new String[]{"aba", "aa", "ba", "aa", "ba"}))
                .add(Arguments.of(false, new String[]{"aba", "ab", "ba", "ba", "ba"}))
                .add(Arguments.of(false, new String[]{"aba", "abc"}))
                .add(Arguments.of(false, new String[]{"aba", "ccc", "ddd", "aba"}))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(boolean expected, String[] input) {
        boolean palindrome = arrayPalindrome.isPalindrome(input);
        assertEquals(expected, palindrome);
    }

}