package org.algorithms.other;

public class JumpingOnClouds {

    public static void main(String[] args) {
        int[] ar = {0, 0, 0, 1, 0, 0};
        System.out.println(jumpingOnClouds(ar));
    }

    static int jumpingOnClouds(int[] c) {

        if (c.length == 0) return 0;

        int amountOfJump = 0, i = 0;
        while(i < c.length) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i += 2;
            } else if (i + 1 < c.length && c[i + 1] == 0) {
                i += 1;
            } else {
                break;
            }
            amountOfJump++;
        }

        // 0 1 2 3 4 5 = 6
        // 0 0 0 1 0 0
        // |   |   |

        return amountOfJump;

    }
}
