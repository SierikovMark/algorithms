package org.algorithms.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionEqualSubsetSumTest {

    private final PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();


    @Test
    void test1() {
        boolean actual = partitionEqualSubsetSum.canPartition(new int[]{1, 5, 11, 5});
        assertTrue(actual);
    }

    @Test
    void test2() {
        boolean actual = partitionEqualSubsetSum.canPartition(new int[]{1, 2, 3, 5});
        assertFalse(actual);
    }

    @Test
    void test3() {
        // 106 -- target = 53
        boolean actual = partitionEqualSubsetSum.canPartition(new int[]{3, 3, 6, 8, 16, 16, 16, 18, 20});
        assertTrue(actual);
    }

}