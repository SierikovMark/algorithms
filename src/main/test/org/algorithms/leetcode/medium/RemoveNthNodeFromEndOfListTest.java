package org.algorithms.leetcode.medium;

import org.algorithms.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RemoveNthNodeFromEndOfListTest {

    RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5)))), new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2))
                .add(Arguments.of(new ListNode(1), new ListNode(1, new ListNode(2)), 1))
                .add(Arguments.of(new ListNode(2), new ListNode(1, new ListNode(2)), 2))
                .add(Arguments.of(null, new ListNode(1), 1))
                .add(Arguments.of(null, null, 1))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV1(ListNode expected, ListNode input, int n) {
        ListNode result = solution.removeNthFromEnd(input, n);
        assertListNode(expected, result);
    }

    @Test
    void should_ThrowRuntimeException_when_nMoreThenLength() {
        assertThrows(RuntimeException.class, () -> solution.removeNthFromEnd(new ListNode(1), 2));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV2(ListNode expected, ListNode input, int n) {
        ListNode result = solution.removeNthFromEndV2(input, n);
        assertListNode(expected, result);
    }

    @Test
    void should_ThrowRuntimeException_when_nMoreThenLengthV2() {
        assertThrows(RuntimeException.class, () -> solution.removeNthFromEndV2(new ListNode(1), 2));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testV3(ListNode expected, ListNode input, int n) {
        ListNode result = solution.removeNthFromEndV3(input, n);
        assertListNode(expected, result);
    }

    @Test
    void should_ThrowRuntimeException_when_nMoreThenLengthV3() {
        assertThrows(RuntimeException.class, () -> solution.removeNthFromEndV3(new ListNode(1), 2));
    }

    private static void assertListNode(ListNode expected, ListNode result) {
        while (expected != null || result != null) {
            if (expected == null || result == null) {
                throw new RuntimeException("List sizes are different");
            }
            assertEquals(expected.val, result.val);
            expected = expected.next;
            result = result.next;
        }
    }
}