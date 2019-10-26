package org.algorithms.collections;

public class Main {

    public static void main(String[] args) {
//        testList(new ArrayList<>());
//        testList(new LinkedList<>());
//        List<String> strings = new LinkedList<>();
//        strings.add("1");
//        strings.add("2");
//        strings.add("3");
//        for (String string : strings) {
//            System.out.println(string);
//        }
//        strings.remove(0);
//
//        System.out.println(strings.firstNode());
//        System.out.println(strings.lastNode());

        Stack<String> stack = new LinkedListStack<>();
        testStack(stack);

    }

    private static void testStack(Stack<String> stack) {
        stack.push("1");
        stack.push("2");
//        stack.push("3");

//        System.out.println(stack.peek());
        printSize(stack);
        System.out.println(stack.pop());
        printSize(stack);
        System.out.println(stack.pop());
        printSize(stack);
        System.out.println(stack.pop());
        printSize(stack);
        System.out.println(stack.pop());
        printSize(stack);
//
        for (String s : stack) {
            System.out.println(s);
        }
    }

    private static void printSize(Stack<String> stack) {
        System.out.println("size = " + stack.size());
        System.out.println("is empty = " + stack.isEmpty());
    }

    private static void testList(List<String> list) {
        list.add("1");
        System.out.println(list.size());
        list.add("2");
        System.out.println(list.size());
        list.add("3");
        System.out.println(list.size());
        list.add("4");
        System.out.println(list.size());
        list.add("5");
        System.out.println(list.size());
        list.add("6");
        System.out.println(list.size());
        list.add("7");
        System.out.println(list.size());
        list.add("8");
        System.out.println(list.size());
        list.add("9");
        System.out.println(list.size());
        list.add("10");
        System.out.println(list.size());

        for (String s : list) {
            System.out.println(s);
        }
        list.remove(1);
        list.remove("3");
        System.out.println(list.size());

        for (String s : list) {
            System.out.println(s);
        }
    }
}
