package org.algorithms.cci.datastructure;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println(linkedList.indexOf("aaa"));
        System.out.println(linkedList.remove("aaa"));
        System.out.println(linkedList.removeAll("aaa"));
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("ccc");
        for (String s : linkedList) {
            System.out.print(s + " ");
        }
        System.out.println(linkedList.indexOf("aaa"));
        System.out.println(linkedList.indexOf("bbb"));
        System.out.println(linkedList.indexOf("ccc"));
        System.out.println(linkedList.remove("aaa"));
        System.out.println(linkedList.indexOf("aaa"));
        linkedList.add("aaa");
        linkedList.add("aaa");
        System.out.println(linkedList.removeAll("aaa"));
        System.out.println(linkedList.getSize());
        for (String s : linkedList) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
//        System.out.println(linkedList.get(2)); // Expected Exception here


    }
}
