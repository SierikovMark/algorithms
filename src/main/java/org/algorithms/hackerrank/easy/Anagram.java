package org.algorithms.hackerrank.easy;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static int anagram(String s) {
        // Write your code here

        Map<Character, Integer> indexPositions = new HashMap<>();

        if (s.length() % 2 == 1) {
            return -1;
        }

        String first = s.substring(0, s.length() / 2);
        String second = s.substring(s.length() / 2);

        char[] firstArray = first.toCharArray();
        int amount = 0;
        for (char ch : firstArray) {
            int index;
            if (indexPositions.containsKey(ch)) {
                index = indexPositions.get(ch);
                index = second.indexOf(ch, index + 1);
            } else {
                index = second.indexOf(ch);
            }

            if (index == -1) {
                amount++;
            } else {
                indexPositions.put(ch, index);
            }
        }
        return amount;
    }

    public static void main(String[] args) {
        int amount = anagram("aabb");
        System.out.printf("2 == %d%n", amount);

        amount = anagram("abc");
        System.out.printf("-1 == %d%n", amount);

        amount = anagram("abaa");
        System.out.printf("1 == %d%n", amount);

        amount = anagram("1122");
        System.out.printf("2 == %d%n", amount);
    }
}
