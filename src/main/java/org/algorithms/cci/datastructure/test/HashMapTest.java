package org.algorithms.cci.datastructure.test;

import org.algorithms.cci.datastructure.Map;
import org.algorithms.cci.datastructure.impl.HashMap;

import java.util.Set;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        System.out.println(map.size());

        System.out.println(map.containsKey("2"));

        System.out.println(map.remove("23"));
        System.out.println(map.remove("2"));
        System.out.println(map.containsKey("2"));

        System.out.println(map.size());
        System.out.println(map.isEmpty());

        Map<String, String> mapToAdd = new HashMap<>();
        mapToAdd.put("10", "10");
        mapToAdd.put("20", "10");
        mapToAdd.put("30", "10");
        mapToAdd.put("40", "10");
        mapToAdd.put("50", "10");
        mapToAdd.put("60", "10");
        mapToAdd.put("70", "10");
        mapToAdd.put("80", "10");
        mapToAdd.put("90", "10");
        mapToAdd.put("100", "10");
        mapToAdd.put("110", "10");
        mapToAdd.put("111", "10");

        map.putAll(mapToAdd);

        Set<HashMap.Entry<String, String>> entries = map.entrySet();

        System.out.println("----------------------------------------------------");
        for (HashMap.Entry<String, String> entry : entries) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        System.out.println(map.size());
    }
}
