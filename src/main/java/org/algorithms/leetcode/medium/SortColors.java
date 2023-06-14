package org.algorithms.leetcode.medium;

public class SortColors {

    public void sortColors(int[] nums) {
        int[] colorsAmount = new int[3];

        for (int num : nums) {
            colorsAmount[num] = colorsAmount[num] + 1;
        }

        int index = 0;
        for(int i = 0; i < colorsAmount.length; i++) {
            int colorAmount = colorsAmount[i];
            while (colorAmount > 0) {
                nums[index++] = i;
                colorAmount--;
            }
        }
    }

    public void sortColorsV2(int[] nums) {
        int left = 0;
        int i = 0;
        int right = nums.length - 1;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void sortColorsV3(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }

        int pivotIndex = partition(nums, start, end);

        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);

    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];

        int i = start - 1;
        int j = start;

        while (j < end) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
            j++;
        }

        i++;
        swap(nums, i, end);
        return i;
    }

    public void sortColorsV4(int[] nums) {
        mergeSort(nums);
    }

    private void mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) {
            return;
        }

        int leftSize = length / 2;
        int rightSize = length - leftSize;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while (index < length) {
            if (leftIndex < leftSize) {
                leftArray[leftIndex] = array[index];
                leftIndex++;
            } else {
                rightArray[rightIndex] = array[index];
                rightIndex++;
            }
            index++;
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);
    }

    private void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                array[index] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[index] = rightArray[rightIndex];
                rightIndex++;
            }
            index++;
        }

        while (leftIndex < leftSize) {
            array[index] = leftArray[leftIndex];
            leftIndex++;
            index++;
        }

        while (rightIndex < rightSize) {
            array[index] = rightArray[rightIndex];
            rightIndex++;
            index++;
        }
    }

    public void sortColorsV5(int[] nums) {
        insertionSort(nums);
    }

    private void insertionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = 1;
        while (i < nums.length) {
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && tmp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
            i++;
        }
    }

}
