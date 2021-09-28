package org.algorithms.hackerrank.ipk.hashmapandsictionaries.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> before = new HashMap<>();
        Map<Long, Long> after = new HashMap<>();
        for(long l : arr) {
            after.putIfAbsent(l, 0L);
            after.computeIfPresent(l, (key, value) -> ++value);
        }
        long count = 0;
        int currentIndex = 0;
        while (currentIndex < arr.size()) {
            long currentValue = arr.get(currentIndex);
            after.computeIfPresent(currentValue, (key, value) -> --value);
            if (after.containsKey(currentValue) && after.get(currentValue) < 1) {
                after.remove(currentValue);
            }
            if (currentValue % r == 0 && before.containsKey(currentValue / r)
                    && after.containsKey(currentValue * r)) {
                count += (before.get(currentValue / r) * after.get(currentValue * r));
            }
            before.putIfAbsent(currentValue, 0L);
            before.computeIfPresent(currentValue, (key, value) -> ++value);
            currentIndex++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(List.of(1L, 2L, 2L, 4L), 2));
        System.out.println(countTriplets(List.of(5L, 5L, 5L, 5L), 1));

    }
}
