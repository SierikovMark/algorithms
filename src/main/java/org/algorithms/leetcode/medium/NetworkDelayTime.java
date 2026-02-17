package org.algorithms.leetcode.medium;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> lookup = new HashMap<>();

        for (int[] time : times) {
            lookup.putIfAbsent(time[0], new ArrayList<>());
            List<int[]> existingTimes = lookup.get(time[0]);
            existingTimes.add(time);
        }

        Map<Integer, Integer> visited = new HashMap<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        List<int[]> kTimes = lookup.get(k);

        if (kTimes == null) {
            return -1;
        }

        visited.put(k, 0);

        for (int[] kTime : kTimes) {
            queue.offer(kTime);
        }

        while (queue.peek() != null) {
            int[] current = queue.poll();

            int currentK = current[0];
            int neighbor = current[1];
            int delay = current[2];

            Integer currentDelay = visited.get(currentK);
            currentDelay += delay;

            if (visited.containsKey(neighbor)) {
                int previousDelay = visited.get(neighbor);
                if (currentDelay >= previousDelay) {
                    continue;
                }
            }

            visited.put(neighbor, currentDelay);

            List<int[]> neighbors = lookup.get(neighbor);

            if (neighbors != null) {
                for (int[] ns : neighbors) {
                    queue.offer(ns);
                }
            }
        }

        if (visited.size() < n) {
            return -1;
        }

        int minDelay = Integer.MIN_VALUE;
        for (int value : visited.values()) {
            if (value > minDelay) {
                minDelay = value;
            }
        }

        return minDelay;
    }

    // First own version
    public int networkDelayTimeV1(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> lookup = new HashMap<>();

        for (int[] time : times) {
            lookup.putIfAbsent(time[0], new ArrayList<>());
            List<int[]> existingTimes = lookup.get(time[0]);
            existingTimes.add(time);
        }

        Map<Integer, Integer> visited = new HashMap<>();
        searchNext(lookup, visited, k, 0);


        if (visited.size() < n) {
            return -1;
        }

        int minDelay = Integer.MIN_VALUE;
        for(int value : visited.values()) {
            if (value > minDelay) {
                minDelay = value;
            }
        }

        return minDelay;
    }

    private void searchNext(Map<Integer, List<int[]>> lookup, Map<Integer, Integer> visited, int k, int previousDelay) {
        int currentDelay = previousDelay;
        visited.put(k, currentDelay);

        List<int[]> times = lookup.get(k);

        if (times == null) {
            return;
        }

        for (int[] time : times) {
            currentDelay = previousDelay;

            int neighbor = time[1];
            int timeValue = time[2];

            currentDelay += timeValue;

            if (visited.containsKey(neighbor)) {
                int existingDelay = visited.get(neighbor);
                if (currentDelay > existingDelay) {
                    continue;
                }
            }
            searchNext(lookup, visited, neighbor, currentDelay);
        }
    }
}
