package org.algorithms;

import java.util.*;

public class Main1 {

    public static int zeros(int n) {

        // your beatiful code here
        if (n / 1000 >= 1) {
            return 0;
        }
        if (n / 50 >= 1) {
            return n / 5 + 4;
        }
        if (n / 25 >= 1) {
            return n / 5 + 1;
        }

        return n / 5;
    }

    public static void main(String[] args) {

     int[] ar = {0,6,14,30,100,1000,100000};

        for (int i : ar) {
            System.out.println( i + " " + zeros(i));
        }

        System.out.println();


//        Map<Long, Long> maps = new TreeMap<>();
//        maps.put(1L, 3L);
//        maps.put(3L, 7L);
//        maps.put(12L, 16L);
//        maps.put(10L, 11L);
//
//        Map<Long, Long> newMap = new HashMap<>();
//        Long tempStartPoint = null, tempEndPoint = null;
//        for (Map.Entry<Long, Long> longLongEntry : maps.entrySet()) {
//            if (tempStartPoint != null) {
//                if (tempEndPoint >= longLongEntry.getKey()) {
//                    newMap.put(tempStartPoint, longLongEntry.getValue());
//                    tempEndPoint = longLongEntry.getValue();
//                } else {
//                    newMap.put(longLongEntry.getKey(), longLongEntry.getValue());
//                    tempStartPoint = longLongEntry.getKey();
//                    tempEndPoint = longLongEntry.getValue();
//                }
//
//            } else {
//                tempStartPoint = longLongEntry.getKey();
//                tempEndPoint = longLongEntry.getValue();
//            }
//        }
//
//        for (Map.Entry<Long, Long> longLongEntry : maps.entrySet()) {
//            System.out.println(longLongEntry);
//        }
//
//        for (Map.Entry<Long, Long> longLongEntry : newMap.entrySet()) {
//            System.out.println(longLongEntry);
//        }


        List<Section> sections = new ArrayList<>();

        Section section = new Section(1, 3);
        sections.add(section);
        section = new Section(3, 7);
        sections.add(section);
        section = new Section(12, 16);
        sections.add(section);
        section = new Section(10, 11);
        sections.add(section);

        sections.sort(Comparator.comparingInt(Section::getStartPoint));

        List<Section> sectionList = new ArrayList<>();

        Section tempSection = null;
        for (Section s : sections) {
            if (tempSection == null) {
                tempSection = s;
            } else {
                if (tempSection.getEndPoint() >= s.getStartPoint()) {
                    sectionList.remove(tempSection);
                    Section e = new Section(tempSection.getStartPoint(), s.getEndPoint());
                    sectionList.add(e);
                    tempSection = e;
                } else {
                    sectionList.add(s);
                }
            }
        }

        for (Section section1 : sectionList) {
            System.out.println(section1);
        }

    }
}

class Section {
    private int startPoint;
    private int endPoint;

    public Section(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return "Section{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}


