package org.algorithms.other;

public class MaximumLengthSwappingNElements {

    public static int maxLengthSwappingNElementsLinear(int[] arr, int k) {
        if (arr.length < k) return arr.length;
        int maxLength = 0;
        int amountOfZero = 0;
        int windowStart = 0;
        int firstZeroElement = -1;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            checkElement(arr, windowEnd);
            int element = arr[windowEnd];
            if (element == 0) {
                if (firstZeroElement == -1) firstZeroElement = windowEnd;
                amountOfZero++;
                if (amountOfZero >= k + 1) {
                    amountOfZero--;
                    windowStart = firstZeroElement + 1;
                }
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static int maxLengthSwappingNElements(int[] arr, int k) {
        if (arr.length < k) return arr.length;
        int maxLength = 0;
        int amountOfZero = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            checkElement(arr, windowEnd);
            int element = arr[windowEnd];
            if (element == 0) {
                amountOfZero++;
                while (amountOfZero >= k + 1) {
                    if (arr[windowStart] == 0) {
                        amountOfZero--;
                    }
                    windowStart++;
                }
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    private static void checkElement(int[] arr, int index) {
        int element = arr[index];
        if (element != 0 && element != 1) 
            throw new IllegalArgumentException(
                String.format("Element should be either 0 or 1, but there is element that is: %d, under index: %d", element, index));
    }

    public static void main(String[] args) {
        System.out.println(maxLengthSwappingNElementsLinear(new int[] {0,1,1,0,0,1,1}, 2) + " - 6");
        System.out.println(maxLengthSwappingNElementsLinear(new int[] {0,0,1,1,1,1,1,0}, 2) + " - 7");
        System.out.println(maxLengthSwappingNElementsLinear(new int[] {0,0,0,0,0,0,0,0}, 3) + " - 3");
        System.out.println(maxLengthSwappingNElementsLinear(new int[] {1,1,1,1,1,0,0,0,1}, 2) + " - 7");
        System.out.println(maxLengthSwappingNElementsLinear(new int[] {}, 2)  + " - 0");
    }
    
}
