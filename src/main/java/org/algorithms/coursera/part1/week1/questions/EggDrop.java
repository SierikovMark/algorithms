package org.algorithms.coursera.part1.week1.questions;

public class EggDrop {

    private static int count = 0;

    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(version0(arr, 98));
        printCount();
        System.out.println(version1(arr, 98));
        printCount();
        System.out.println(version2(arr, 98));
        printCount();

    }

    private static void printCount() {
        System.out.println("It took = " + count + " iteration");
        count = 0;
    }

    // Version 0: 1 egg, T≤T tosses.
    public static int version0(int[] buildings, int criticalFlor) {
        // we will use just brute-force
        for (int i = 0; i < buildings.length; i++) {
            count++;
            if (buildings[i] >= criticalFlor) {
                return buildings[i];
            }

        }
        return -1;
    }

    // ∼1*lgn eggs and ∼1*lgn tosses
    public static int version1(int[] buildings, int criticalFlor) {
        // we will use binary search
        int lo = 0;
        int hi = buildings.length;

        int mid = (lo + hi) / 2;

        while(lo <= hi) {
            count++;
            if (buildings[mid] == criticalFlor) {
                return buildings[mid];
            }
            if (buildings[mid] > criticalFlor) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }
        return -1;
    }

    // ∼lgT eggs and ∼2lgT tosses
    public static int version2(int[] buildings, int criticalFlor) {

        int lastIndex = 0;
        for (int i = 1; i < buildings.length; i = i * 2) {
            count++;
            lastIndex = i;
            int flor = buildings[i];
            if (flor > criticalFlor) {
                // make binary search
                int lo = i / 2;
                int hi = flor;
                int mid = (lo + hi) / 2;
                while (lo <= hi) {
                    count++;
                    if (buildings[mid] == criticalFlor) return buildings[mid];

                    if (buildings[mid] > criticalFlor) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                    mid = (hi + lo) / 2;
                }
            }
        }

        // make binary search
        int lo = lastIndex / 2;
        int hi = buildings.length - 1;
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            count++;
            if (buildings[mid] == criticalFlor) return buildings[mid];

            if (buildings[mid] > criticalFlor) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            mid = (hi + lo) / 2;
        }

        return -1;
    }
}
