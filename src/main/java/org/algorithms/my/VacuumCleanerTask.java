package org.algorithms.my;

import java.util.Random;

public class VacuumCleanerTask {

    public static void main(String[] args) {
        Random r = new Random();
        int low = 0;
        int high = 10;
        int x = r.nextInt(high-low) + low;
        int y = r.nextInt(high-low) + low;

        System.out.println("x=" + x);
        System.out.println("y=" + y);


        int [][] field = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                field[i][j] = 0;
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        VacuumCleaner vacuumCleaner = new VacuumCleaner(field);
        vacuumCleaner.setX(x);
        vacuumCleaner.setY(y);

        vacuumCleaner.clean();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}

class VacuumCleaner {

    private int x;
    private int y;

    private int[][] field;

    public VacuumCleaner(int[][] field) {
        this.field = field;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean moveLeft() {
        if (x - 1 >= 0) {
            x--;
            field[y][x] = 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean moreRight() {
        if (x + 1 < field.length) {
            x++;
            field[y][x] = 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean moveUp() {
        if (y - 1 > -1) {
            y--;
            field[y][x] = 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean moveDown() {
        if (y + 1 > field.length) {
            y++;
            field[y][x] = 1;
            return true;
        } else {
            return false;
        }
    }

    public void clean() {
        moveAtStartPoint();
        while (true) {
            while (moreRight());
            y++;
            if (y >= field.length) break;
            field[y][x] = 1;
            while (moveLeft());
            y++;
            if (y >= field.length) break;
            field[y][x] = 1;
        }
    }

    public void moveAtStartPoint() {
        while (moveUp());
        while (moveLeft());
    }
}


