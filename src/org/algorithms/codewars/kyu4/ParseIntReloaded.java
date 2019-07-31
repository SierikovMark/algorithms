package org.algorithms.codewars.kyu4;

import java.util.HashMap;
import java.util.Map;

public class ParseIntReloaded {

    public static void main(String[] args) {
//        System.out.println(parseInt("one"));
//        System.out.println(parseInt("twenty"));
//        System.out.println(parseInt("two hundred forty-six"));
        System.out.println(parseInt("nine thousand one hundred and thirty-eight"));
    }

    private final static Map<String, Integer> integerMap = new HashMap();
    private final static Map<String, Integer> tens = new HashMap();

    static {
        tens.put("hundred", 100);
        tens.put("hundreds", 100);

        tens.put("thousand", 1000);
        tens.put("thousands", 1000);

        tens.put("million", 1000000);
        tens.put("millions", 1000000);
    }

    static {
        integerMap.put("one", 1);
        integerMap.put("two", 2);
        integerMap.put("three", 3);
        integerMap.put("four", 4);
        integerMap.put("five", 5);
        integerMap.put("six", 6);
        integerMap.put("seven", 7);
        integerMap.put("eight", 8);
        integerMap.put("nine", 9);

        integerMap.put("ten", 10);
        integerMap.put("eleven", 11);
        integerMap.put("twelve", 12);
        integerMap.put("thirteen", 13);
        integerMap.put("fourteen", 14);
        integerMap.put("fifteen", 15);
        integerMap.put("sixteen", 16);
        integerMap.put("seventeen", 17);
        integerMap.put("eighteen", 18);
        integerMap.put("nineteen", 19);

        integerMap.put("twenty", 20);
        integerMap.put("thirty", 30);
        integerMap.put("forty", 40);
        integerMap.put("fifty", 50);
        integerMap.put("sixty", 60);
        integerMap.put("seventy", 70);
        integerMap.put("eighty", 80);
        integerMap.put("ninety", 90);

    }

    public static int parseInt(String numStr) {

        System.out.println(numStr);

        if (numStr == null) return -1;

        int result = 0;

        if ("zero".equals(numStr)) return result;

        String[] numbers = numStr.split("\\s");

        int tempValue = 0;

        for (int i = 0; i < numbers.length; i++) {
            String currentValue = numbers[i];
            if (currentValue.contains("-")) {
                String[] currentValueSplitted = currentValue.split("-");
                tempValue += getValueFromIntegerMap(currentValueSplitted[0]);
                tempValue += getValueFromIntegerMap(currentValueSplitted[1]);
            }
            if (integerMap.containsKey(currentValue)) {
                int current = integerMap.get(currentValue);
                tempValue += current;
            }
            if (tens.containsKey(currentValue)) {
                int currentTens = tens.get(currentValue);
                tempValue *= currentTens;
                if (i < numbers.length - 1) {
                    if (findTens(i + 1, numbers)) continue;
                }
                result += tempValue;
                tempValue = 0;
            }
        }
        if (tempValue > 0) result += tempValue;
        return result;
    }

    private static int getValueFromIntegerMap(String value) {
        if (!integerMap.containsKey(value)) throw new RuntimeException("No such value present: " + value);
        return integerMap.get(value);
    }

    private static boolean findTens(int index, String[] numbers) {
        for (int i = index; i < numbers.length; i++) {
            String current = numbers[i];
            if ("thousand".equals(current)) return true;
        }
        return false;
    }
}
