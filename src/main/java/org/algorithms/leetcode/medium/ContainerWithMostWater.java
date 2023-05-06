package org.algorithms.leetcode.medium;

public class ContainerWithMostWater {


    public int maxArea(int[] height) {
        int volume = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int maxPossibleHeight = Math.min(height[i], height[j]);
                int currentVolume = maxPossibleHeight * (j - i);
                if (currentVolume > volume) {
                    volume = currentVolume;
                }
            }
        }
        return volume;
    }

    public int maxAreaV2(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int volume = 0;
        int lo = 0;
        int hi = height.length - 1;
        do {
            int width = hi - lo;
            int left = height[lo];
            int right = height[hi];
            int maxPossibleHeight = Math.min(left, right);
            int currentVolume = maxPossibleHeight * width;
            volume = Math.max(currentVolume, volume);

            if (left < right) {
                lo++;
            } else {
                hi--;
            }
        } while (lo < hi);

        return volume;
    }
}
