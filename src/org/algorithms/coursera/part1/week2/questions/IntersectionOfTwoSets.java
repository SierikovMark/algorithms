package org.algorithms.coursera.part1.week2.questions;

import org.algorithms.coursera.part1.week2.sort.Shellsort;

import java.util.Objects;

public class IntersectionOfTwoSets {

    public static int getIntersectionCount(Point[] firstSet, Point[] secondSet) {
        if (firstSet == null || secondSet == null || firstSet.length == 0 || secondSet.length == 0)
            throw new IllegalArgumentException();

        // Lets sort both of sets in order to apply binary search, worst case for both n ^ 2 / 4 (I used implementation from the course).
        Shellsort.sort(firstSet);
        Shellsort.sort(secondSet);

        int count = 0;
        for (int i = 0; i < firstSet.length; i++) {
            Point pointFromFirstSet = firstSet[i];

            // Binary search will provide Log N (base of 2 ) in worst case.
            int lo = 0, hi = secondSet.length - 1;
            int mid = (lo + hi) / 2;
            while (lo <= hi) {
                Point pointFromSecondSet = secondSet[mid];
                int compareIndex = pointFromSecondSet.compareTo(pointFromFirstSet);
                if (compareIndex == 0) {
                    count++;
                    break;
                }
                if (compareIndex > 0) {
                    hi = mid - 1;
                }
                if (compareIndex < 0) {
                    lo = mid + 1;
                }
                mid = (lo + hi) / 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Point[] set1 = new Point[3];
        set1[0] = new Point(1,1);
        set1[1] = new Point(2,2);
        set1[2] = new Point(3,3);

        Point[] set2 = new Point[3];
        set2[0] = new Point(1,1);
        set2[1] = new Point(2,2);
        set2[2] = new Point(5,3);
        set2[2] = new Point(6,3);

        System.out.println(getIntersectionCount(set1, set2));
    }
}

class Point implements Comparable<Point>{
    private Double x;
    private Double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point o) {
        int xDiff = this.x.compareTo(o.x);
        if (xDiff != 0) return xDiff;
        else return this.y.compareTo(o.y);
    }
}
