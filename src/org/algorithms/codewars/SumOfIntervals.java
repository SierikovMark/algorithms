package org.algorithms.codewars;

import java.util.Arrays;
import java.util.Comparator;

public class SumOfIntervals {

    public static void main(String[] args) {


        // 18968
        System.out.println(sumIntervals(new int[][]{{-9790, -6396}, {-9781, -5685}, {-9622, -3404}, {-8820, 4725}, {-8657, 279}, {-7808, 9178}, {-7695, -6766}, {-7306, 1486}, {-7305, -6885}, {-7221, -5573}, {-6926, 1405}, {-6884, 7732}, {-5773, -5127}, {-5561, 6246}, {-4823, 7600}, {-4745, 6726}, {-3922, 1098}, {-2116, 1293}, {-995, 4131}, {-504, 4503}, {842, 8737}, {1096, 1328}, {1661, 8027}, {1702, 8530}}));

//        System.out.println(sumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}}));
//        System.out.println(sumIntervals(new int[][]{{4, 8}, {9, 10}, {15, 21}}));
//        System.out.println(sumIntervals(new int[][]{{-1, 4}, {-5, -3}}));
//        System.out.println(sumIntervals(new int[][]{{-245, -218}, {-194, -179}, {-155, -119}}));
//
//        System.out.println();
//
//        System.out.println(sumIntervals(new int[][]{{1, 2}, {2, 6}, {6, 55}}));
//        System.out.println(sumIntervals(new int[][]{{-2, -1}, {-1, 0}, {0, 21}}));
//
//        System.out.println();
//
//        System.out.println(sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}}));
//        System.out.println(sumIntervals(new int[][]{{5, 8}, {3, 6}, {1, 2}}));
//        System.out.println(sumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
//
//        System.out.println();
//
//        System.out.println(sumIntervals(new int[][]{{2, 5}, {-1, 2}, {-40, -35}, {6, 8}}));
//        System.out.println(sumIntervals(new int[][]{{-7, 8}, {-2, 10}, {5, 15}, {2000, 3150}, {-5400, -5338}}));
//        System.out.println(sumIntervals(new int[][]{{-101, 24}, {-35, 27}, {27, 53}, {-105, 20}, {-36, 26},}));
    }


    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int endPoint = Integer.MIN_VALUE, result = 0;
        for (int[] interval : intervals) {
            int currentStartPoint = interval[0];
            int currentEndPoint = interval[1];

            if (interval.length != 2) return -1;

            if (currentStartPoint > endPoint) {
                result += currentEndPoint - currentStartPoint;
                endPoint = currentEndPoint;
            } else {
                if (currentEndPoint > endPoint) {
                    result += currentEndPoint - endPoint;
                    endPoint = currentEndPoint;
                }
            }
        }
        return result;
    }
}

