package org.algorithms.coursera.part1.homework.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final WeightedQuickUnionUF grid;
    private final WeightedQuickUnionUF gridForCheckFull;
    private final int gridFullSize, virtualTopIndex, virtualBottomIndex, size;
    private int numberOfOpenedSites = 0;

    private boolean[] sites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("Given n <= 0");
        }

        size = n;
        gridFullSize = n * n;

        virtualTopIndex = gridFullSize;
        virtualBottomIndex = gridFullSize + 1;

        grid = new WeightedQuickUnionUF(gridFullSize + 2);
        gridForCheckFull = new WeightedQuickUnionUF(gridFullSize + 1);

        sites = new boolean[gridFullSize];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkRowAndColInRange(row, col);
        if (!isOpen(row, col)) {
            sites[getIndex(row, col)] = true;
            numberOfOpenedSites++;
        }
        connectToVirtualTop(row, col);
        connectLeft(row, col);
        connectUp(row, col);
        connectRight(row, col);
        connectBottom(row, col);
        connectToVirtualBottom(row, col);
    }

    private void connectToVirtualBottom(int row, int col) {
        if (row == size) {
            grid.union(getIndex(row, col), virtualBottomIndex);
        }
    }

    private void connectToVirtualTop(int row, int col) {
        if (row == 1) {
            grid.union(getIndex(row, col), virtualTopIndex);
            gridForCheckFull.union(getIndex(row, col), virtualTopIndex);
        }
    }

    private void connectBottom(int row, int col) {
        if (row * size + 1 < gridFullSize && isOpen(row + 1, col)) {
            grid.union(getIndex(row, col), getIndex(row + 1, col));
            gridForCheckFull.union(getIndex(row, col), getIndex(row + 1, col));
        }
    }

    private void connectRight(int row, int col) {
        if (col * size + 1 < gridFullSize - 1 && isOpen(row, col + 1)) {
            grid.union(getIndex(row, col), getIndex(row, col + 1));
            gridForCheckFull.union(getIndex(row, col), getIndex(row, col + 1));
        }
    }

    private void connectUp(int row, int col) {
        if (row - 1 > 0 && isOpen(row - 1, col)) {
            grid.union(getIndex(row, col), getIndex(row - 1, col));
            gridForCheckFull.union(getIndex(row, col), getIndex(row - 1, col));
        }
    }

    private void connectLeft(int row, int col) {
        if (col - 1 > 0 && isOpen(row, col - 1)) {
            grid.union(getIndex(row, col), getIndex(row, col - 1));
            gridForCheckFull.union(getIndex(row, col), getIndex(row, col - 1));
        }
    }

    private void checkRowAndColInRange(int row, int col) {
        checkPointInRange(row);
        checkPointInRange(col);
    }

    private void checkPointInRange(int i) {
        if (i > sites.length || i * size - 1 > sites.length || i < 1)
            throw new IllegalArgumentException("Not in range: " + i);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkRowAndColInRange(row, col);
        return sites[getIndex(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkRowAndColInRange(row, col);
        return gridForCheckFull.connected(virtualTopIndex, getIndex(row, col));
    }

    private int getIndex(int row, int col) {
        return (row - 1) * size + (col - 1);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenedSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return grid.connected(virtualTopIndex, virtualBottomIndex);
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(3, 1);
        System.out.println(percolation.isFull(3, 1));
    }

}
