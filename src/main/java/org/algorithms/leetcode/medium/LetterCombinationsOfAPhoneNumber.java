package org.algorithms.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    private final String[] MAPPING = new String[] {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // Recursive solution
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        combine(result, "", 0, digits);
        return result;
    }

    private void combine(List<String> result, String prefix, int offset, String digits) {
        if (prefix.length() >= digits.length()) {
            result.add(prefix);
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(offset));
        String keyLetter = MAPPING[digit];

        for (char letter : keyLetter.toCharArray()) {
            combine(result, prefix + letter, offset + 1, digits);
        }
    }

    // Bottom-Up approach
    public List<String> letterCombinationsV2(String digits) {
        Deque<String> queue = new ArrayDeque<>();

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        queue.offer("");

        for (int i = 0; i < digits.length(); i++) {

            int digit = digits.charAt(i) - '0';

            String keyLetters = MAPPING[digit];

            while (queue.peek() != null && queue.peek().length() == i) {
                String prefix = queue.poll();

                for (char letter : keyLetters.toCharArray()) {
                    queue.offer(prefix + letter);
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
