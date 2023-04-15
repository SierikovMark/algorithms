package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeLinkedListTest {

    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))), true))
                .add(Arguments.of(new ListNode(1, new ListNode(2)), false))
                .add(Arguments.of(new ListNode(1, new ListNode(2, new ListNode(1))), true))
                .build();
    }

    @MethodSource("testData")
    @ParameterizedTest
    void test(ListNode input, boolean expected) {
        boolean actual = palindromeLinkedList.isPalindrome(input);
        assertEquals(expected, actual);
    }

}