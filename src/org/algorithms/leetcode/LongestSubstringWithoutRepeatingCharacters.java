package org.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        int lengthOfLongestSubstring = 0;
        int windowStart = 0;

        HashSet<Character> hash = new HashSet<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd);
            while (hash.contains(c)) {
                hash.remove(s.charAt(windowStart));
                windowStart++;
            }
            hash.add(c);
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, windowEnd - windowStart + 1);
        }

        return lengthOfLongestSubstring;
    }

    public static int lengthOfLongestSubstringBruteForce(String s) {
        if (s.length() < 2) return s.length();
        char[] sa = s.toCharArray();
        int longest = 0;
        Set<Character> hash = new HashSet<>();
        for (int i = 0; i < sa.length; i++) {
            char first = sa[i];
            hash.add(first);
            for (int j = i + 1; j < sa.length; j++) {
                char second = sa[j];
                if (hash.contains(second)) {
                    break;
                }
                hash.add(second);
            }
            longest = Math.max(hash.size(), longest);
            hash = new HashSet<>();
        }
        return longest;
    }

    public static void main(String[] args) {
       System.out.println(lengthOfLongestSubstring("ckilbkd") + " 5");
       System.out.println(lengthOfLongestSubstring("dvdf") + " 3");
       System.out.println(lengthOfLongestSubstring("tmmzuxt") + " 5");
       System.out.println(lengthOfLongestSubstring("bbbbb") + " 1");
       System.out.println(lengthOfLongestSubstring("pwwkew") + " 3");
    }
}
