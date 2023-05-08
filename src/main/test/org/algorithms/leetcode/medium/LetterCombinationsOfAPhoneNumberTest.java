package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LetterCombinationsOfAPhoneNumberTest {

    LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(List.of("dg", "dh", "di", "eg", "eh", "ei", "fg", "fh", "fi"), "23"))
                .add(Arguments.of(List.of(), ""))
                .add(Arguments.of(List.of("mgj",  "mgk",  "mgl",  "mhj",  "mhk",  "mhl",  "mij",  "mik",  "mil",  "ngj",  "ngk",  "ngl",  "nhj",  "nhk",  "nhl",  "nij",  "nik",  "nil",  "ogj",  "ogk",  "ogl",  "ohj",  "ohk",  "ohl",  "oij",  "oik",  "oil"), "534"))
                .add(Arguments.of(List.of("d", "e", "f"), "2"))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void testV1(List<String> expected, String input) {
        List<String> result = letterCombinationsOfAPhoneNumber.letterCombinations(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(List<String> expected, String input) {
        List<String> result = letterCombinationsOfAPhoneNumber.letterCombinationsV2(input);
        assertEquals(expected, result);
    }

}