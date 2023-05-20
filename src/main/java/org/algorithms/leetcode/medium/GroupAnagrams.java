package org.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    // aab -> [2, 1, 0, 0, ....]
    // baa -> [2, 1, 0, 0, ....]
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            char[] newChars = new char[26];
            for (char strChar : strChars) {
                newChars[strChar - 'a']++;
            }
            String key = String.valueOf(newChars);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
