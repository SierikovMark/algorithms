package org.algorithms.interview;

public class FindMaxSumNoAdjusted {

    private static int counterBefore = 0;
    private static int counter = 0;

    private static int[] temp;

    public static void main(String[] args) {

        int[] arr = {1 , 2, 3, 4, 5, 6,7,8,9,10, 1 , 2, 3, 4, 5, 6,7,8,9,10, 1 , 2, 3, 4, 5, 6,7,8,9,10, 1 , 2, 3, 4, 5, 6,7,8,9,10};

        temp = new int[arr.length];

        System.out.println(findMax(0, arr));
        System.out.println(findMaxSum( arr, arr.length));
        System.out.println(myImp(arr));

        System.out.println(counterBefore);
        System.out.println(counter);


    }

    static int myImp(int arr[]) {

        int tempSum = 0;
        int sumExcludePrev = 0;
        int sumIncludePrev = arr[0];


        for (int i = 1; i < arr.length; i++) {

            int currentElement = arr[i];

            if (currentElement + sumExcludePrev > sumIncludePrev) {
                tempSum = currentElement + sumExcludePrev;
            } else {
                tempSum = sumExcludePrev;
            }

            sumExcludePrev = sumIncludePrev;
            sumIncludePrev = tempSum;

        }

        return sumIncludePrev > sumExcludePrev ? sumIncludePrev : sumExcludePrev;
    }

    static int findMaxSum(int arr[], int n)
    {
        int maxSumIncludingPrevElements = arr[0];
        int maxSumExcludingPrevElements = 0;
        int tempSum;

        for (int i = 1; i < n; i++)
        {
            /* current max excluding i */
            tempSum = (maxSumIncludingPrevElements > maxSumExcludingPrevElements) ? maxSumIncludingPrevElements : maxSumExcludingPrevElements;

            /* current max including i */
            maxSumIncludingPrevElements = maxSumExcludingPrevElements + arr[i];
            maxSumExcludingPrevElements = tempSum;
        }

        /* return max of incl and excl */
        return ((maxSumIncludingPrevElements > maxSumExcludingPrevElements) ? maxSumIncludingPrevElements : maxSumExcludingPrevElements);
    }


    public static int findMax(int index, int[] arr) {
        counterBefore++;
        if (index >= arr.length) {
            return 0;
        }
        counter++;

        if (temp[index] != 0) return temp[index];

        int value = arr[index];

        int resultFromCurrent = value + findMax(index + 2, arr);
        int resultFromNext = findMax(index + 1, arr);

        int i = resultFromCurrent > resultFromNext ? resultFromCurrent : resultFromNext;

        temp[index] = i;

        return i;


    }
}
