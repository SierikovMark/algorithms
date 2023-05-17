package org.algorithms.codewars.kyu4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseIntReloadedProperSolution {

    private static final Map<String, Integer> NUMBERS = new HashMap<>();

    private static final Map<String, Integer> MULTY = new HashMap<>();

    static {
        NUMBERS.put("zero", 0);
        NUMBERS.put("one", 1);
        NUMBERS.put("two", 2);
        NUMBERS.put("three", 3);
        NUMBERS.put("four", 4);
        NUMBERS.put("five", 5);
        NUMBERS.put("six", 6);
        NUMBERS.put("seven", 7);
        NUMBERS.put("eight", 8);
        NUMBERS.put("nine", 9);
        NUMBERS.put("ten", 10);
        NUMBERS.put("eleven", 11);
        NUMBERS.put("twelve", 12);
        NUMBERS.put("thirteen", 13);
        NUMBERS.put("fourteen", 14);
        NUMBERS.put("fifteen", 15);
        NUMBERS.put("sixteen", 16);
        NUMBERS.put("seventeen", 17);
        NUMBERS.put("eighteen", 18);
        NUMBERS.put("nineteen", 19);
        NUMBERS.put("twenty", 20);
        NUMBERS.put("thirty", 30);
        NUMBERS.put("forty", 40);
        NUMBERS.put("fifty", 50);
        NUMBERS.put("sixty", 60);
        NUMBERS.put("seventy", 70);
        NUMBERS.put("eighty", 80);
        NUMBERS.put("ninety", 90);
        MULTY.put("hundred", 100);
        MULTY.put("thousand", 1000);
        MULTY.put("thousands", 1000);
        MULTY.put("million", 1000000);
    }


    public int parseInt(String numStr) {
        // Your code here!
        int result = 0;
        List<Integer> results = new ArrayList<>();
        String[] split = numStr.replaceAll(" and ", " ").replaceAll("-", " ").split(" ");

        for (String s : split) {
            if (NUMBERS.containsKey(s)) {
                result += NUMBERS.get(s);
            } else {
                result *= MULTY.get(s);
                if (result >= 1000) {
                    results.add(result);
                    result = 0;
                }
            }
        }

        for (Integer res : results) {
            result += res;
        }

        return result;
    }

}
