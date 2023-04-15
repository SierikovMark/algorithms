package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainsDuplicateTest {

    ContainsDuplicate containsDuplicate = new ContainsDuplicate();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(new int[]{1, 2, 3, 1}, true))
                .add(Arguments.of(new int[]{1, 2, 3, 4}, false))
                .add(Arguments.of(new int[]{1, 2, 3, 4, 4}, true))
                .add(Arguments.of(new int[]{1, 2, 3, 4, 3}, true))
                .build();
    }

    @MethodSource("testData")
    @ParameterizedTest
    void test(int[] nums, boolean expected) {
        boolean actual = containsDuplicate.containsDuplicate(nums);
        assertEquals(expected, actual);
    }

}