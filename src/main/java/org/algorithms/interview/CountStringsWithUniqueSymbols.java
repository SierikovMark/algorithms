package org.algorithms.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountStringsWithUniqueSymbols {

    Map<String, Integer> count(List<String> input) {

        List<String> stringsWithUniqueCharacters = new ArrayList<>();
        for (String string : input) {
            Set<Character> tmp = new LinkedHashSet<>();
            char[] chars = string.toCharArray();
            for (char aChar : chars) {
                tmp.add(aChar);
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : tmp) {
                stringBuilder.append(character);
            }
            stringsWithUniqueCharacters.add(stringBuilder.toString());
        }

        Map<String, Integer> result = new HashMap<>();
        for (String stringWithUniqueCharacter : stringsWithUniqueCharacters) {
            result.compute(stringWithUniqueCharacter, (k, v) -> (v == null) ? 1: v + 1);
        }

        return result;
    }
}
