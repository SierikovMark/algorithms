package org.algorithms.collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        System.out.println(arrayList.size());
        arrayList.add("2");
        System.out.println(arrayList.size());
        arrayList.add("3");
        System.out.println(arrayList.size());
        arrayList.add("4");
        System.out.println(arrayList.size());
        arrayList.add("5");
        System.out.println(arrayList.size());
        arrayList.add("6");
        System.out.println(arrayList.size());
        arrayList.add("7");
        System.out.println(arrayList.size());
        arrayList.add("8");
        System.out.println(arrayList.size());
        arrayList.add("9");
        System.out.println(arrayList.size());
        arrayList.add("10");
        System.out.println(arrayList.size());

        for (String s : arrayList) {
            System.out.println(s);
        }
        arrayList.remove(1);
        arrayList.remove("3");
        System.out.println(arrayList.size());

        for (String s : arrayList) {
            System.out.println(s);
        }

    }
}
