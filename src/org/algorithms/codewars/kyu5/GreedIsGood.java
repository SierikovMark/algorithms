package org.algorithms.codewars.kyu5;

import java.util.HashMap;
import java.util.Map;

public class GreedIsGood {

    public static void main(String[] args) {
        System.out.println(greedy(new int[]{2,4,4,5,4}));
    }

    public static int greedy(int[] dice) {
        Map<Integer, Integer> map = new HashMap<>();

        int score = 0;

        for(int i = 0; i < dice.length; i++) {
            int value = dice[i];
            if (map.containsKey(value)) {
                int currentCount = map.get(value);
                currentCount++;
                map.put(value, currentCount);
            } else {
                map.put(value, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (key == 1) {
                if (value >= 3) {
                    score += 1000;
                    value -= 3;
                }
                score += value * 100;
            }
            if (key == 6) {
                if (value == 3) score += value * 600;
            }
            if (key == 5) {
                if (value >= 3) {
                    score += 500;
                    value -= 3;
                }
                score += value * 50;
            }
            if (key == 4) {
                if (value == 3) score += value * 400;
            }
            if (key == 3) {
                if (value == 3) score += value * 300;
            }
            if (key == 2) {
                if (value == 3) score += value * 200;
            }
        }
        return score;
    }

//    Better and simple solution from codewars.
//    public static int greedy(int[] dice) {
//        int n[] = new int[7];
//        for (int d : dice) n[d]++;
//        return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
//    }
}
