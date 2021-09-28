package org.algorithms.hackerrank.ipk.hashmapandsictionaries.medium;

import java.util.HashMap;
import java.util.Map;

public class SherlockAnagram {

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        int count = 0;
        int lo = 0, size = 1;
        while(lo < s.length()) {
            String toSearch = s.substring(lo, lo + size);
            int tmpLo = lo + 1;
            while (tmpLo + size <= s.length()) {
                String toCompare = s.substring(tmpLo, tmpLo + size);
                if (isAnagram(toSearch, toCompare)) {
                    count++;
                }
                tmpLo++;
            }
            size++;
            if (lo + size >= s.length()) {
                lo++;
                size = 1;
            }
        }
        return count;
    }

    private static boolean isAnagram(String str1, String str2) {
        Map<Character, Integer> positions = new HashMap<>();
        char[] firstArray = str1.toCharArray();
        for (char ch : firstArray) {
            int index;
            if (positions.containsKey(ch)) {
                index = positions.get(ch);
                index = str2.indexOf(ch, index + 1);
            } else {
                index = str2.indexOf(ch);
            }

            if (index == -1) {
                return false;
            } else {
                positions.put(ch, index);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(sherlockAndAnagrams("abba"));
    }
}
