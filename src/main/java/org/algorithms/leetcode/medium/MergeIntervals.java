package org.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

        List<int[]> intervalsStorage = new ArrayList<>();
        intervalsStorage.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = intervalsStorage.get(intervalsStorage.size() - 1);
            int[] currentInterval = intervals[i];

            if (lastInterval[1] >= currentInterval[0]) {
                intervalsStorage.remove(intervalsStorage.size() - 1);
                int left = Math.min(lastInterval[0], currentInterval[0]);
                int right = Math.max(lastInterval[1], currentInterval[1]);
                intervalsStorage.add(new int[] {left, right});
            } else {
                intervalsStorage.add(currentInterval);
            }
        }

        return intervalsStorage.toArray(new int[intervalsStorage.size()][2]);
    }

    // Not my solution. It works slower since to separate arrays sort
    public int[][] mergeV2(int[][] intervals) {
        // sort start&end
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<int[]> result = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                result.add(new int[] {starts[j], ends[i]});
                j = i + 1;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
