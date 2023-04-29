package org.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Set<Integer> takenIndexes = new HashSet<>();

        //             |
        // a n a g r a m
        //
        // n a g a r a m

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i); // 6 = m

            for (int j = 0; j < t.length(); j++) {
                char tChar = t.charAt(j); // 5 = a

                if (sChar == tChar && !takenIndexes.contains(j)) {
                    takenIndexes.add(j); // 1, 0, 3, 2, 4, 5, 6
                    break;
                }
            }

            if (takenIndexes.size() != i + 1) {
                return false;
            }
        }

        return true;

    }

    public boolean isAnagramV2(String s, String t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charAmountMap = new HashMap<>();

        char[] tChars = t.toCharArray();

        for (char currentChar : tChars) {
            if (charAmountMap.containsKey(currentChar)) {
                int amount = charAmountMap.get(currentChar);
                charAmountMap.put(currentChar, ++amount);
            } else {
                charAmountMap.put(currentChar, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);

            if (!charAmountMap.containsKey(sChar)) {
                return false;
            }

            int charAmount = charAmountMap.get(sChar);
            charAmount--;
            charAmountMap.put(sChar, charAmount);
            if (charAmount <= 0) {
                charAmountMap.remove(sChar);
            }
        }

        return true;
    }

    public boolean isAnagramV3(String s, String t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> characterMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentCharS = s.charAt(i);
            char currentCharT = t.charAt(i);
            characterMap.put(currentCharS, characterMap.getOrDefault(currentCharS, 0) + 1);
            characterMap.put(currentCharT, characterMap.getOrDefault(currentCharT, 0) - 1);
        }

        for (Integer value : characterMap.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
