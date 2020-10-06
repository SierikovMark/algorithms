package org.algorithms.other;

public class HourGlasses {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println(hourglassSum(arr));
    }

    static int hourglassSum(int[][] arr) {
        if (arr.length < 3) return 0;


        int max = arr[0][0] + arr[0][1] + arr[0][2] + arr[1][1] + arr[2][0] + arr[2][1] + arr[2][2];
        for (int i = 0; i + 3 <= arr.length; i++) {
            if (arr[i].length < 3) throw new IllegalArgumentException("Length of array should be equal or more than 3");
            for (int j = 0; j + 3 <= arr.length; j++) {
                int current =
                        arr[i][j]   + arr[i][j+1]   + arr[i][j+2]
                                    + arr[i+1][j+1] +
                        arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(current > max) max = current;
            }
        }

        return max;
    }
}
