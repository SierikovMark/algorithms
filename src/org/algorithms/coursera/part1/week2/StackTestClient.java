package org.algorithms.coursera.part1.week2;

public class StackTestClient {

    public static void main(String[] args) {

        StackOfStrings stack = new StackOfStringsBasedOnArray();

//        while (!StdIn.isEmpty()) {
//            String s = StdIn.readString();
//            if (s.equals("-")) StdOut.print(stack.pop());
//            else               stack.push(s);
//        }

        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

        stack.push("6");
        System.out.println(stack.isEmpty());
        stack.push("7");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

//        StackGeneric<String> stackGeneric = new StackGenericBasedOnArray<>();
        StackGeneric<String> stackGeneric = new StackGenericBasedOnLinkedList<>();
        stackGeneric.push("1");
        stackGeneric.push("2");
        stackGeneric.push("3");


        System.out.println("---------------------------");
        for (String s : stackGeneric) {
            System.out.println(s);
        }
        System.out.println("---------------------------");

        System.out.println(stackGeneric.peek());
        System.out.println(stackGeneric.pop());
        System.out.println(stackGeneric.peek());


    }
}
