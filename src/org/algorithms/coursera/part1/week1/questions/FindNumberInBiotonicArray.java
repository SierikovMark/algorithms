package org.algorithms.coursera.part1.week1.questions;

public class FindNumberInBiotonicArray {

    static int count = 0;


    public static void main(String[] args) {

//        int[] arr = {-3, 9, 10, 20, 17, 5, 1};

        int[] arr = new int[100000000];

        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = i * 2;
        }

        for (int i = (arr.length / 2); i < arr.length; i++) {
            arr[i] = (arr.length - i) * 2 - 3;
        }

        System.out.println(findValueInBiotonic(0, arr));
        printCount();
//        System.out.println(findValueInBiotonic(9, arr));
//        printCount();
//        System.out.println(findValueInBiotonic(10, arr));
//        printCount();
//        System.out.println(findValueInBiotonic(20, arr));
//        printCount();
//        System.out.println(findValueInBiotonic(17, arr));
//        printCount();
//        System.out.println(findValueInBiotonic(5, arr));
//        printCount();
//        System.out.println(findValueInBiotonic(1, arr));
//        printCount();
//        System.out.println(findValueInBiotonic(-1, arr));
//        printCount();
        
    }

    private static void printCount() {
        System.out.println(count);
        count = 0;
        System.out.println();
    }


    public static int findValueInBiotonic(int value, int[] arr) {
        // find biotonic point
        int lo = 0, hi = arr.length - 1;
        int mid = (lo + hi) / 2;

        int current;
        int left;
        int right;

        int biotonicPoint = -1;
        while (mid <= hi) {
            count++;
            current = arr[mid];
            left = arr[mid - 1];
            right = arr[mid + 1];

            if (left < current && current > right) {
                biotonicPoint = mid;
                break;
            }

            if (left > current && current > right) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }

        System.out.println("For searching biotonic point =" + count);

        if (arr[mid] == value) return mid;


        lo = biotonicPoint + 1; hi = arr.length - 1;
        mid = (lo + hi) / 2;
        while (lo <= hi) {
            count++;
            if (arr[mid] == value) return mid;

            if (arr[mid] > value) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            mid = (lo + hi) / 2;
        }

        lo = 0; hi = biotonicPoint - 1;
        mid = (lo + hi) / 2;
        while (lo <= hi) {
            count++;
            if (arr[mid] == value) return mid;

            if (arr[mid] > value) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }

        return -1;

    }
}
