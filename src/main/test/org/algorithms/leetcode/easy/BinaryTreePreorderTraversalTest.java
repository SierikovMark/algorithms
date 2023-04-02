package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreePreorderTraversalTest {

    BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(List.of(1, 2, 3), new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))))
                .add(Arguments.of(List.of(), null))
                .add(Arguments.of(List.of(1), new TreeNode(1)))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldTraverseWithPreorderPath(List<Integer> expected, TreeNode treeNode) {
        List<Integer> actual = binaryTreePreorderTraversal.preorderTraversal(treeNode);
        assertEquals(expected, actual);
    }

}