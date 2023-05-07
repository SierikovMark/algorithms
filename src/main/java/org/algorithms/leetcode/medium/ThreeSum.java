package org.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Set<List<Integer>> tmpResult = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triple = new ArrayList<>(3);
                        triple.add(nums[i]);
                        triple.add(nums[j]);
                        triple.add(nums[k]);
                        tmpResult.add(triple.stream().sorted().collect(Collectors.toList()));
                    }
                }
            }
        }

        result.addAll(tmpResult);

        return result;
    }

    public List<List<Integer>> threeSumV2(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            int j = i + 1;
            int k = length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));

                    while (j < k) {
                        if (nums[j] == nums[j + 1]) {
                            j++;
                        } else {
                            break;
                        }
                    }

                    while (j < k) {
                        if (nums[k] == nums[k - 1]) {
                            k--;
                        } else {
                            break;
                        }
                    }

                    j++;
                    k--;
                }
            }

            while (i < length - 1) {
                if (nums[i] == nums[i + 1]) {
                    i++;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
