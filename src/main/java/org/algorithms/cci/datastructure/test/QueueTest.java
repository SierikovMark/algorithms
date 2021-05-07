package org.algorithms.cci.datastructure.test;

import org.algorithms.cci.datastructure.LinkedQueue;
import org.algorithms.cci.datastructure.Queue;

public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedQueue<>();

        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        queue.offer("111");
        queue.offer("222");
        System.out.println(queue.peekFirst().equals(queue.peekLast()));
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.offer("3333");
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.peekFirst().equals(queue.peekLast()));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
