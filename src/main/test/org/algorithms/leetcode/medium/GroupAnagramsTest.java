package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

    GroupAnagrams groupAnagrams = new GroupAnagrams();


    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(
                        List.of(List.of("tan", "nat"), List.of("eat", "tea", "ate"), List.of("bat")),
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}))
                .add(Arguments.of(
                        List.of(List.of("a")),
                        new String[]{"a"}))
                .add(Arguments.of(
                        List.of(List.of("")),
                        new String[]{""}))
                .add(Arguments.of(
                        List.of(List.of("", "")),
                        new String[]{"", ""}))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test(List<List<String>> expected, String[] input) {
        List<List<String>> result = groupAnagrams.groupAnagrams(input);
        assertEquals(expected, result);
    }

}