package org.algorithms.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidAnagramTest {

    ValidAnagram validAnagram = new ValidAnagram();

    @Test
    void testAnagram() {
        boolean anagram = validAnagram.isAnagram("anagram", "nagaram");
        assertTrue(anagram);
    }

    @Test
    void testNotAnagram() {
        boolean anagram = validAnagram.isAnagram("rat", "cat");
        assertFalse(anagram);
    }

    @Test
    void testAnagramV2() {
        boolean anagram = validAnagram.isAnagramV2("anagram", "nagaram");
        assertTrue(anagram);
    }

    @Test
    void testNotAnagramV2() {
        boolean anagram = validAnagram.isAnagramV2("rat", "cat");
        assertFalse(anagram);
    }

    @Test
    void testAnagramV3() {
        boolean anagram = validAnagram.isAnagramV3("anagram", "nagaram");
        assertTrue(anagram);
    }

    @Test
    void testNotAnagramV3() {
        boolean anagram = validAnagram.isAnagramV3("rat", "cat");
        assertFalse(anagram);
    }

}