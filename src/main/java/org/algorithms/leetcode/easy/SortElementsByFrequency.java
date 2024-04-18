package org.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortElementsByFrequency {

    public List<Integer> sort(List<Integer> input) {

//        [3, 4, 7, 6, 6, 5, 5, 5]
//        [4, 3, 5, 6, 5, 7, 6, 5]

        Map<Integer, Integer> numberFrequency = new TreeMap<>();

        for (Integer number : input) {
            numberFrequency.putIfAbsent(number, 0);
            int frequency = numberFrequency.get(number);
            numberFrequency.put(number, ++frequency);
        }

        Map<Integer, Set<Integer>> reversedFrequency = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : numberFrequency.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            reversedFrequency.putIfAbsent(frequency, new TreeSet<>());

            Set<Integer> numbers = reversedFrequency.get(frequency);
            numbers.add(number);
        }

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Set<Integer>> entry : reversedFrequency.entrySet()) {
            int frequency = entry.getKey();
            Set<Integer> numbers = entry.getValue();

            for (Integer number : numbers) {
                for (int i = 0; i < frequency; i++) {
                    result.add(number);
                }
            }
        }

        return result;
    }

    // time -> N * log(N)
    public List<Integer> sort2(List<Integer> input) {
        Map<Integer, Integer> numberFrequency = new HashMap<>();

        for (Integer number : input) {
            numberFrequency.compute(number, (key, value) -> value != null ? ++value : 0);
        }

        List<Integer> result = new ArrayList<>(input);

        result.sort((a, b) -> {
            if (numberFrequency.get(a).equals(numberFrequency.get(b))) {
                return a - b;
            } else {
                return numberFrequency.get(a) - numberFrequency.get(b);
            }
        });

        return result;
    }

}
