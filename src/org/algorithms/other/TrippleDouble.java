package org.algorithms.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrippleDouble {

    public static void main(String[] args) {
        System.out.println(TripleDouble(451999277L, 41177722899L));
    }

    public static int TripleDouble(long num1, long num2)
    {
        //code me ^^

        System.out.println(num1 + " " + num2);
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);

        Map<Character, Integer> maps= new HashMap<>();

        char[] charArray = str1.toCharArray();

        Character lastChar = null;
        for (int i = 0; i < charArray.length; i++) {
            Character c = charArray[i];
            if (maps.containsKey(c) && c.equals(lastChar)) {
                Integer value = maps.get(c);
                value++;
                maps.put(c, value);
            } else {
                maps.put(c, 1);
            }
            lastChar = c;
        }

        List<Character> trippleChars = maps.entrySet()
                .stream().filter(e -> e.getValue() == 3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (trippleChars == null || trippleChars.size() == 0) {
            return 0;
        }

        char[] charArray2 = str2.toCharArray();

        char val = trippleChars.get(0);

        lastChar = null;
        maps = new HashMap<>();
        for (int i = 0; i < charArray2.length; i++) {
            Character c = charArray2[i];
            if (maps.containsKey(c) && c.equals(lastChar) && c.equals(val)) {
                Integer value = maps.get(c);
                value++;
                maps.put(c, value);
            } else {
                maps.put(c, 1);
            }
            lastChar = c;
        }

        List<Character> chars2List = maps.entrySet().stream().filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        if (chars2List.size() == 1) return 1;

        return 0;
    }
}
