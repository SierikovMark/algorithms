package org.algorithms.interview;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<String> make(String input) {
        List<String> result = new ArrayList<>();

        backtracking(result, "", input, input.length());

        return result;
    }


    private void backtracking(List<String> result, String string, String variants, int size) {
        if (string.length() == size) {
            result.add(string);
            return;
        }

        for (int i = 0; i < variants.length(); i++) {
            String leftVariants = variants.substring(0, i) + variants.substring(i + 1);
            backtracking(result, string + variants.charAt(i), leftVariants, size);
        }
    }

    //   "abc" -> [abc, acb, bac, bca, cab, cba]
}
