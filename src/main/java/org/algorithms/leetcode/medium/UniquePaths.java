package org.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        Set<String> visited = new HashSet<>();
        AtomicInteger result = new AtomicInteger();
        move(0, 0, m, n, visited, result);
        return result.get();
    }

    private void move(int i, int j, int m, int n, Set<String> visited, AtomicInteger result) {
        String key = String.format("%s-%s", i, j);
        if (i >= m || j >= n || visited.contains(key)) {
            return;
        }
        if (i == m - 1 && j == n - 1) {
            result.incrementAndGet();
        }

        visited.add(key);

        Set<String> visitedNew = new HashSet<>(visited);

        move(i, j + 1, m, n, visitedNew, result);
        move(i + 1, j, m, n, visitedNew, result);
    }

    // More clear recursive solution with memoization
    public int uniquePathsV2(int m, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return moveV2(m - 1, n - 1, memo);
    }

    int moveV2(int m, int n, Map<String, Integer> memo) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (m < 0 || n < 0) {
            return 0;
        }

        String key = String.format("%s-%s", m, n);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int totalSubSteps = moveV2(m, n - 1, memo) + moveV2(m - 1, n, memo);
        memo.put(key, totalSubSteps);
        return totalSubSteps;
    }

    // It is combinatorial task, since we have to move only right and down we can calculate all combination as
    // (m+n)! / (m! * n!)
    public int uniquePathsV3(int m, int n) {
        m--;
        n--;
        long divisor = factorialUsingRecursion(m) * factorialUsingRecursion(n);
        if (divisor == 0) {
            return 1;
        }
        return (int) (factorialUsingRecursion(m + n) / divisor);
    }

    private long factorialUsingRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorialUsingRecursion(n - 1);
    }

    public int uniquePathsV4(int m, int n) {
        int[][] field = new int[m][n];

        for (int i = 0; i < m; i++) {
            field[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            field[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                field[i][j] = field[i - 1][j] + field[i][j - 1];
            }
        }

        return field[m - 1][n - 1];
    }

    public int uniquePathsV5(int m, int n) {
        int[] row = new int[n];
        // Arrays.fill(row, 1); // We can init it with 1 for each cell and start for loop from i = 1

        int[] newRow = new int[n];
        newRow[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                newRow[j] = newRow[j - 1] + row[j];
            }
            row = newRow;
        }

        return row[n - 1];
    }
}
