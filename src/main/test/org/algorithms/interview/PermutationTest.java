package org.algorithms.interview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationTest {

    Permutation permutation = new Permutation();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(List.of(""),  ""))
                .add(Arguments.of(List.of("a"),  "a"))
                .add(Arguments.of(List.of("ab", "ba"),  "ab"))
                .add(Arguments.of(List.of("abc",  "acb",  "bac",  "bca",  "cab",  "cba"),  "abc"))
                .add(Arguments.of(List.of("aaa",  "aaa",  "aaa",  "aaa",  "aaa",  "aaa"),  "aaa"))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void testV1(List<String> expected, String input) {
        List<String> result = permutation.make(input);
        assertEquals(expected, result);
    }

}