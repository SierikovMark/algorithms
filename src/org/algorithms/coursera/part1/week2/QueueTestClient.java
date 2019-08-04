package org.algorithms.coursera.part1.week2;

public class QueueTestClient {

    public static void main(String[] args) {
        QueueOfStrings queue = new QueueOfStringsBasedOnArray();

//        while (!StdIn.isEmpty()) {
//            String s = StdIn.readString();
//            if (s.equals("-")) StdOut.print(stack.pop());
//            else               stack.push(s);
//        }

        queue.endueue("1");
        queue.endueue("2");
        queue.endueue("3");

        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());

        queue.endueue("6");
        System.out.println(queue.isEmpty());
        queue.endueue("7");
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());

    }
}
