package org.algorithms.my.topsellers;

import org.algorithms.collections.Pair;
import org.algorithms.collections.PriorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TopSellers {


    public List<Pair<String, Integer>> getTopSellers(Selling[] sellings, int number) {

        Map<String, Integer> aggregated = new HashMap<>();

        for (Selling sale : sellings) {
            String name = sale.getName();
            aggregated.put(name, aggregated.getOrDefault(name, 0) + sale.getAmount());
        }

        PriorityQueue<Map.Entry<String, Integer>> heap =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<String, Integer> entry : aggregated.entrySet()) {
            heap.offer(entry);
            if (heap.size() > number) {
                heap.poll();
            }
        }


        List<Pair<String, Integer>> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            Map.Entry<String, Integer> poll = heap.poll();
            result.addFirst(new Pair<>(poll.getKey(), poll.getValue()));
        }

        return result;

    }



    public List<Pair<String, Integer>> getTopSellersV1(Selling[] sellings, int number) {

        Map<String, Integer> aggregated = Arrays.stream(sellings)
                .collect(Collectors.groupingBy(
                        Selling::getName,
                        Collectors.summingInt(Selling::getAmount))
                );

        return aggregated
                .entrySet()
                .stream()
                .map(e -> new Pair<>(e.getKey(), e.getValue()))
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(number)
                .toList();


    }



}
