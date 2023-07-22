package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubsetsTest {

    Subsets subsets = new Subsets();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(List.of(
                        List.of(0),
                        List.of()
                ), new int[]{0}))
                .add(Arguments.of(List.of(
                        List.of(1, 2, 3),
                        List.of(1, 2),
                        List.of(1, 3),
                        List.of(1),
                        List.of(2, 3),
                        List.of(2),
                        List.of(3),
                        List.of()
                ), new int[]{1, 2, 3}))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test(List<List<Integer>> expected, int[] input) {
        List<List<Integer>> result = subsets.subsets(input);
        assertThat(result).hasSameElementsAs(expected);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(List<List<Integer>> expected, int[] input) {
        List<List<Integer>> result = subsets.subsetsV2(input);
        assertThat(result).hasSameElementsAs(expected);
    }

}