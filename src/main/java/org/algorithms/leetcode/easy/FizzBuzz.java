package org.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);

        int i = 1;
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
            i++;
        }
        return result;
    }

    public List<String> fizzBuzzV2(int n) {
        List<String> result = new ArrayList<>(n);

        int i = 1;
        int fizz = 1;
        int buzz = 1;
        while (i <= n) {
            if (fizz == 3 && buzz == 5) {
                result.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                result.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                result.add("Buzz");
                buzz = 0;
            } else {
                result.add(String.valueOf(i));
            }
            i++;
            fizz++;
            buzz++;
        }

        return result;
    }

}
