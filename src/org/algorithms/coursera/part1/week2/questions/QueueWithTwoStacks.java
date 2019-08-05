package org.algorithms.coursera.part1.week2.questions;

import java.util.Stack;

public class QueueWithTwoStacks<T> {

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void endueue(T item) {
        if (stack1.isEmpty())  {
            stack1.push(item);
            return;
        }
        if (stack2.isEmpty()) {
            stack2.push(item);
            return;
        }

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        stack2.push(item);

        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
    }

    public T dequeue() {
        if (stack1.isEmpty()) return null;
        T item = stack1.pop();
        if (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return item;
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }


    public static void main(String[] args) {
        QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<>();

        queue.endueue("1");
        queue.endueue("2");
        queue.endueue("3");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.endueue("4");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}