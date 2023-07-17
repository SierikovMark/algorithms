package org.algorithms.interview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrogHopAndJumpCombinationsTest {

    FrogHopAndJumpCombinations frogHopAndJumpCombinations = new FrogHopAndJumpCombinations();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(List.of("hop"), 1))
                .add(Arguments.of(List.of("hop hop", "jump"), 2))
                .add(Arguments.of(List.of("hop hop hop", "hop jump", "jump hop"), 3))
                .add(Arguments.of(List.of("hop hop hop hop", "hop hop jump", "hop jump hop", "jump hop hop", "jump jump"), 4))
                .add(Arguments.of(List.of(
                        "hop hop hop hop hop",
                        "hop hop hop jump",
                        "hop hop jump hop",
                        "hop jump hop hop",
                        "hop jump jump",
                        "jump hop hop hop",
                        "jump hop jump",
                        "jump jump hop"
                ), 5))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(List<String> expected, int input) {
        List<String> result = frogHopAndJumpCombinations.hopAndJump(input);
        assertEquals(expected, result);
    }

}