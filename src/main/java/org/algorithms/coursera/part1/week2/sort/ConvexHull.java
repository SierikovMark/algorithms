package org.algorithms.coursera.part1.week2.sort;

import java.util.*;

public class ConvexHull {

    public static List<Point> getConvexHullPoints(Point[] points) {

        if (points.length < 3) throw new IllegalArgumentException();

        Deque<Point> hull = new ArrayDeque<>();

        Arrays.sort(points, Comparator.comparingDouble(p -> p.y));
        Arrays.sort(points, Comparator.comparingDouble(p -> -p.x));

        if (points.length == 3) return Arrays.asList(points);

        hull.push(points[0]);
        hull.push(points[2]);

        for (int i = 2; i < points.length; i++) {
            Point top = hull.pop();
            while (ccw(hull.peek(), top, points[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points[i]);
        }
        return new ArrayList<>(hull);
    }

    private static int ccw(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) throw new IllegalArgumentException();
        double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area < 0) return -1;
        if (area > 0) return +1;
        return 0;
    }


    public static void main(String[] args) {
        Point[] points = new Point[4];
        points[0] = new Point(6, 0);
        points[1] = new Point(6, 6);
        points[2] = new Point(0, 0);
        points[3] = new Point(5, 1);

        List<Point> convexHullPoints = getConvexHullPoints(points);

        for (Point convexHullPoint : convexHullPoints) {
            System.out.println("x=" + convexHullPoint.x + ", y=" + convexHullPoint.y);
        }
    }
}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
