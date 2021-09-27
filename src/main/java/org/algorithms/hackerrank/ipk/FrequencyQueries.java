package org.algorithms.hackerrank.ipk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrequencyQueries {
    private static Map<Integer, Integer> valueToFrequency;
    private static Map<Integer, Set<Integer>> frequencyToNumbers;

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        // init caches
        valueToFrequency = new HashMap<>(queries.size());
        frequencyToNumbers = new HashMap<>(queries.size());
        // init result
        List<Integer> result = new ArrayList<>();
        // execute all queries
        for(List<Integer> query: queries) {
            int operationResult = executeOperation(query.get(0), query.get(1));
            if (operationResult >= 0) {
                result.add(operationResult);
            }
        }
        return result;
    }

    private static int executeOperation(int operationId, int argument) {
        if (operationId == 1) {
            add(argument);
        } else if (operationId == 2) {
            delete(argument);
        } else if (operationId == 3) {
            return compute(argument);
        }
        return -1;
    }

    private static void add(int argument) {
        int amount = valueToFrequency.getOrDefault(argument, 0);
        valueToFrequency.put(argument, amount + 1);

        Set<Integer> numbers = frequencyToNumbers.get(amount);
        if (numbers != null) {
            numbers.remove(argument);
            if (numbers.size() == 0) {
                numbers = null;
            }
        }
        if (numbers == null) {
            frequencyToNumbers.remove(amount);
        }

        if (!frequencyToNumbers.containsKey(amount + 1)) {
            frequencyToNumbers.put(amount + 1, new HashSet<>());
        }
        frequencyToNumbers.get(amount + 1).add(argument);
    }

    private static void delete(int argument) {
        if (valueToFrequency.containsKey(argument)) {
            int amount = valueToFrequency.get(argument);
            if (amount - 1 < 1) {
                valueToFrequency.remove(argument);
            } else {
                valueToFrequency.put(argument, amount - 1);
            }
            if (frequencyToNumbers.containsKey(amount)) {
                Set<Integer> numbers = frequencyToNumbers.get(amount);
                numbers.remove(argument);
                if (numbers.size() < 1) {
                    frequencyToNumbers.remove(amount);
                }
            }
            if (amount - 1 > 0) {
                frequencyToNumbers.putIfAbsent(amount - 1, new HashSet<>());
                frequencyToNumbers.get(amount - 1).add(argument);
            }
        }
    }

    private static int compute(int argument) {
        return frequencyToNumbers.containsKey(argument) ? 1 : 0;
    }

    public static void main(String[] args) {
        List<Integer> integers = freqQuery(List.of(
                List.of(1, 5),
                List.of(1, 6),
                List.of(3, 2),
                List.of(1, 10),
                List.of(1, 10),
                List.of(1, 6),
                List.of(2, 5),
                List.of(3, 2)
        ));

        System.out.println("0 == " + integers.get(0));
        System.out.println("1 == " + integers.get(1));
    }
}
