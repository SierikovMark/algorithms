package org.algorithms.coursera.part1.homework.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double VAL_FOR_CALC_CONFIDENCE = 1.96;
    private final int trials;
    private final double[] trialsValues;
    private double mean = 0.0;
    private double stddev = 0.0;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("n or trials <= 0, n=" + n + ", trials=" + trials);

        this.trials = trials;
        this.trialsValues = new double[trials];

        for (int i = 0; i < this.trials; i++) {
             Percolation percolation = new Percolation(n);
             while (!percolation.percolates()) {
                 int row = StdRandom.uniform(1, n + 1);
                 int col = StdRandom.uniform(1, n + 1);
                 if (!percolation.isOpen(row, col)) percolation.open(row, col);
             }
            trialsValues[i] = (double) percolation.numberOfOpenSites() / (n*n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        if (mean == 0.0) {
            mean = StdStats.mean(trialsValues);
        }
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (stddev == 0.0) {
            stddev = StdStats.stddev(trialsValues);
        }
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((VAL_FOR_CALC_CONFIDENCE * stddev()) / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((VAL_FOR_CALC_CONFIDENCE * stddev()) / Math.sqrt(trials));
    }

    // test client (see below)
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(n, trials);

        String interval = percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi();

        System.out.println("mean                    = " + percolationStats.mean());
        System.out.println("stddev                  = " + percolationStats.stddev());
        System.out.println("95% confidence interval = " + interval);

    }

}
