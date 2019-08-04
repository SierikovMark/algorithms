package org.algorithms.coursera.part1.week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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

    }
}
