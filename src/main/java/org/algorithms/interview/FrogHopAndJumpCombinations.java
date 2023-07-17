package org.algorithms.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FrogHopAndJumpCombinations {

    /*
    * time complexity O(2^n - 1), memory complexity O(n)
     */
    public List<String> hopAndJump(int n) {
        List<String> result = new ArrayList<>();
        backTracking(result, new ArrayList<>(), 0, n);
        return result;
    }

    void backTracking(List<String> result, List<Integer> current, int position, int n) {
        if (position == n) {
            result.add(current.stream().map(this::map).collect(Collectors.joining(" ")));
            return;
        }

        if (position + 1 <= n) {
            current.add(1);
            backTracking(result, current, position + 1, n);
            current.remove(current.size() - 1);
        }
        if (position + 2 <= n) {
            current.add(2);
            backTracking(result, current, position + 2, n);
            current.remove(current.size() - 1);
        }
    }

    private String map(int i) {
        if (i == 1) {
            return "hop";
        } else if (i == 2) {
            return "jump";
        } else {
            throw new RuntimeException(String.valueOf(i));
        }
    }

}
