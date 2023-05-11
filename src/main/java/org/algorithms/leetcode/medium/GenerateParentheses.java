package org.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, 0, 0, n, "");
        return result;
    }

    private void helper(List<String> result, int open, int close, int n, String current) {
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }
        if (open < n) {
            helper(result, open + 1, close, n, current + "(");
        }
        if (close < open) {
            helper(result, open, close + 1, n, current + ")");
        }
    }

    // ["(())", "()()"], 0, 0, 2, "" -> call
    //   ["(())", "()()"], 1, 0, 2, "(" -> open
    //     ["(())", "()()"], 2, 0, 2 "((" -> open
    //       ["(())", "()()"], 2, 1, 2, "(()" -> close
    //         ["(())", "()()"] 2, 2, 2, "(())" -> close
    //           result.add -> "(())"
    //   ["(())", "()()"], 1, 1, 2, "()" -> close
    //     ["(())", "()()"], 2, 1, 2, "()(" -> open
    //       ["(())", "()()"], 2, 2, 2, "()()" -> close
    //         result.add() -> "()()"



    /*
    * ()()()(), ()()(()), ()(())(), ()(()()), ()((())), (())()(), (())(()),        (()())(), ((()))(),    (()()()), (()(())), ((())()), ((()())), (((())))
    *
    *  f(0): n = 0 -> ""
    *  f(1): n = 1 -> () - (f0)
    *  f(2): n = 2 -> ()() -> (f0)f1, (()) -> (f1)
    *  f(3): n = 3 -> (f0)f2 -> ()()(), ()(()), (f1)f1 -> (())(),  (f2) = (()()), ((()))
    *  f(4): n = 4 -> (f0)f3 -> ()()()(), ()()(()), ()(())(), ()(()()), ()((())), (f1)f2 -> (())()(), (())(()), (f2)f1 -> (()())(), ((()))() (f3) -> (()()()), (()(())), ((())()), ((()())), (((())))
    *  f(5): n = 5 -> (f0)f4, (f1)f3, (f2)f2, (f3)f1, (f4)
    *  f(n): n = n -> (f0)fn-1, (f1)fn-2, (f2)fn-3 ... (fi)fn-1-i ... (fn-1)
    *
     */
    public List<String> generateParenthesisV2(int n) {
        List<List<String>> aggregation = new ArrayList<>();
        List<String> iterationZero = new ArrayList<>();
        iterationZero.add("");
        aggregation.add(iterationZero); // n = 0

        for (int i = 1; i <= n; i++) {
            List<String> result = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> list1 = aggregation.get(j);
                for (String first : list1) {
                    List<String> list2 = aggregation.get(i - 1 - j);

                    for (String second : list2) {
                        result.add("(" + first + ")" + second);
                    }
                }
            }
            aggregation.add(result);
        }

        return aggregation.get(aggregation.size() - 1);
    }
}

