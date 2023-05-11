package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateParenthesesTest {

    GenerateParentheses generateParentheses = new GenerateParentheses();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(List.of(""), 0))
                .add(Arguments.of(List.of("()"), 1))
                .add(Arguments.of(List.of("(())", "()()"), 2))
                .add(Arguments.of(List.of("((()))", "(()())", "(())()", "()(())", "()()()"), 3))
                .add(Arguments.of(List.of("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())",  "(()())()",  "(())(())",  "(())()()",  "()((()))",  "()(()())",  "()(())()",  "()()(())",  "()()()()"),  4))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV1(List<String> expected, int n) {
        List<String> result = generateParentheses.generateParenthesis(n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(List<String> expected, int n) {
        List<String> result = generateParentheses.generateParenthesisV2(n);
        result.sort(String::compareTo);
        assertEquals(expected, result);
    }

}