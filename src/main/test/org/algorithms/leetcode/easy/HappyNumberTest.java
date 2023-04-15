package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HappyNumberTest {

    HappyNumber happyNumber = new HappyNumber();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(19 ,true))
                .add(Arguments.of(2 ,false))
                .add(Arguments.of(101 ,false))
                .add(Arguments.of(82 ,true))
                .build();
    }

    @MethodSource("testData")
    @ParameterizedTest
    void test(int input, boolean expected) {
        boolean isHappy = happyNumber.isHappy(input);
        assertEquals(expected, isHappy);

    }

}