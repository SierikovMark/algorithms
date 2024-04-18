package org.algorithms.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortElementsByFrequencyTest {

    private final SortElementsByFrequency sortElementsByFrequency = new SortElementsByFrequency();

    @Test
    void sort() {
        List<Integer> input = List.of(4, 3, 5, 6, 5, 7, 6, 5);

        List<Integer> actual = sortElementsByFrequency.sort(input);
        List<Integer> expected = List.of(3, 4, 7, 6, 6, 5, 5, 5);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    void sort2() {
        List<Integer> input = List.of(4, 3, 5, 6, 5, 7, 6, 5);

        List<Integer> actual = sortElementsByFrequency.sort2(input);
        List<Integer> expected = List.of(3, 4, 7, 6, 6, 5, 5, 5);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

}