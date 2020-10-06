package org.algorithms.coursera.part1.week1;

public class QuickFindWithFindMax extends QuickFindUF {

    public static void main(String[] args) {
        QuickFindWithFindMax quickFindWithFindMax = new QuickFindWithFindMax(10);
        quickFindWithFindMax.union(1, 3);
        quickFindWithFindMax.union(7, 9);
        quickFindWithFindMax.union(3, 7);

        System.out.println(quickFindWithFindMax.find(0));
        System.out.println(quickFindWithFindMax.find(1));
    }

    int[] maxIds;

    public QuickFindWithFindMax(int N) {
        super(N);
        maxIds = new int[N];
        for (int i = 0; i < maxIds.length; i++) {
            maxIds[i] = i;
        }
    }

    public int find(int p) {
        int max = p;
        while (ids[p] != p) {
            if (ids[p] > max) max = ids[p];
            p = ids[p];
        }
        return max;
    }
}
