package org.algorithms.interview;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountStringsWithUniqueSymbolsTest {

    CountStringsWithUniqueSymbols counter = new CountStringsWithUniqueSymbols();


    @Test
    void test() {
        Map<String, Integer> expected = Map.of(
                "ab", 2,
                "ba", 1
        );
        Map<String, Integer> count = counter.count(List.of("aba", "ab", "ba"));
        assertEquals(expected, count);
    }
}