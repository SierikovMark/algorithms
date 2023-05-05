package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(List.of("1", "2", "Fizz"), 3))
                .add(Arguments.of(List.of("1", "2", "Fizz", "4", "Buzz"), 5))
                .add(Arguments.of(List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"), 15))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV1(List<String> expected, int input) {
        List<String> actual = fizzBuzz.fizzBuzz(input);
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(List<String> expected, int input) {
        List<String> actual = fizzBuzz.fizzBuzzV2(input);
        assertEquals(expected, actual);

    }

}