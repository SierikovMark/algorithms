package org.algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {


//        String s = "(java)";
//
//
//        Pattern pattern = Pattern.compile("(.java).\\d*");
//
//        Matcher matcher = pattern.matcher(s);
//        System.out.println(matcher.find());

        int[][] ints = {{1, 3}, {2, 3}, {4, 5}};
        int[][] ints1 = sortAndMerge2(ints);
//
//        for (Object o : ints3) {
//            System.out.println(((int[])o)[0]+ " "+ ((int[])o)[1]);
//        }

        for (int[] ints2 : ints1) {
            System.out.println(ints2[0] + " " + ints2[1]);
        }
    }

    public static void go(int[][] intervals) {
        List<Integer> collect = Arrays.stream(intervals)
                .flatMapToInt(interval -> IntStream.range(interval[0], interval[1])).distinct().boxed().collect(Collectors.toList());

        for (Integer integer : collect) {
            System.out.println(integer);
        }

    }


    public static int[][] sortAndMerge(int[][] sections) {

        if (sections == null || sections.length == 0 || sections[0].length != 2) return sections;

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < sections.length; i++) {
            int[] section = sections[i];
            int currentStartPoint = section[0];
            int currentEndPoint = section[1];
            if (!map.containsKey(currentStartPoint) || map.get(currentStartPoint) < currentEndPoint) {
                map.put(currentStartPoint, currentEndPoint);
            }
        }

        int[][] result = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            result[i][0] = integerIntegerEntry.getKey();
            result[i][1] = integerIntegerEntry.getValue();
            i++;
        }
        return result;
    }



    public static int[][] sortAndMerge2(int[][] sections) {

        if (sections == null || sections.length == 0 || sections[0].length != 2) return sections;

        Arrays.sort(sections, Comparator.comparingInt(e -> e[0]));

        int endPoint = sections[0][1];
        List<int[]> ints = new ArrayList<>();
        for (int i = 0; i < sections.length; i++) {
            int[] section = sections[i];
            int currentStartPoint = section[0];
            int currentEndPoint = section[1];
            if (i == 0 || currentStartPoint > endPoint) {
                ints.add(section);
                endPoint = currentEndPoint;
            } else {
                if (currentEndPoint > endPoint) {
                    int[] ints1 = ints.get(ints.size() - 1);
                    ints1[1] = currentEndPoint;
                    endPoint = currentEndPoint;
                }

            }
        }

        return ints.toArray(new int[ints.size()][2]);
    }
}
