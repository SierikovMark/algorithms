package org.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        int assumedUniqueIndex = 0;
        int length = s.length();
        while (assumedUniqueIndex < length) {
            char assumedUniqueLetter = s.charAt(assumedUniqueIndex);
            int currentIndex = 0;
            boolean unique = true;
            while (currentIndex < length) {
                char currentLetter = s.charAt(currentIndex);
                if (assumedUniqueLetter == currentLetter
                        && assumedUniqueIndex != currentIndex) {
                    unique = false;
                    break;
                }
                currentIndex++;
            }
            if (unique) {
                return assumedUniqueIndex;
            }
            assumedUniqueIndex++;
        }

        return -1;
    }

    public int firstUniqCharV2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (s.indexOf(currentChar) == s.lastIndexOf(currentChar)) {
                return i;
            }
        }
        return -1;
    }


    public int firstUniqCharV3(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        Map<Character, Integer> characters = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            characters.compute(aChar, (k, v) -> v == null ? 1 : v + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (characters.get(aChar) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqCharV4(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        Map<Character, Integer> characters = new LinkedHashMap<>();
        Set<Character> characterSet = new HashSet<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (characterSet.contains(currentChar)) {
                characters.remove(currentChar);
            } else {
                characterSet.add(currentChar);
                characters.put(currentChar, i);
            }
        }

        return characters.size() == 0 ? -1 : characters.entrySet().iterator().next().getValue();
    }
}
