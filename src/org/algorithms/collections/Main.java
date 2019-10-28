package org.algorithms.collections;

import java.util.Comparator;

public class Main {


    static class Node<E> {
        E element;
        Node<E> leftNode;
        Node<E> rightNode;

        public Node(E element) {
            this.element = element;
        }
    }

    public static void main(String[] args) {
//        testList(new ArrayList<>());
//        testList(new LinkedList<>());
//        testStack(stack);
//        testQueue(new LinkedListQueue<>());

//        Deque<String> strings = new LinkedListDeque<>();
//        testQueueBasedOnDeque(strings);
//        testStackBasedOnDeque(strings);
//        testDeque(strings);
//
//        testBinaryTree();

        Heap<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        integers.offer(12);
        integers.offer(15);
        integers.offer(11);
        integers.offer(100);
        integers.offer(21);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        System.out.println("-------------------------");
        System.out.println(integers.poll());
        System.out.println("-------------------------");

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    private static void testBinaryTree() {
        Tree<Integer> strings = new BinaryTree<>();
        strings.add(10);
        strings.add(20);
        strings.add(30);
        strings.add(5);
        strings.add(40);
        strings.add(11);
        strings.add(50);


        for (Integer string : strings) {
            System.out.println(string);
        }

        System.out.println(strings.search(100));
        System.out.println(strings.search(11));


        System.out.println("--------------------------------------");
        System.out.println(strings.search(20));
        strings.remove(20);
        System.out.println(strings.search(20));

        for (Integer string : strings) {
            System.out.println(string);
        }
    }

    private static void printNode(Node<String> node) {
        if (node == null) return;
        System.out.println(node.element);
        printNode(node.leftNode);
        printNode(node.rightNode);
    }

    private static void printNode1(Node<String> node) {
        Deque<Node<String>> strings = new ArrayDeque<>();
        strings.offer(node);
        while (!strings.isEmpty()) {
            Node<String> pop = strings.pop();
            System.out.println(pop.element);
            if (pop.leftNode != null) strings.offer(pop.leftNode);
            if (pop.rightNode != null) strings.offer(pop.rightNode);
        }
    }



    private static void testDeque(Deque<String> strings) {
        strings.offer("1");
        strings.push("2");
        System.out.println("size = " + strings.size());
        System.out.println(strings.isEmpty());
        System.out.println(strings.peek());
        System.out.println("first = " + strings.peekFirst());
        System.out.println("last = " + strings.peekLast());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println("size = " + strings.size());
        System.out.println(strings.isEmpty());
    }

    private static void testStackBasedOnDeque(Deque<String> strings) {
        strings.push("1");
        strings.push("2");
        strings.push("3");
        System.out.println("size = " + strings.size());
        System.out.println(strings.isEmpty());
        System.out.println(strings.peek());
        System.out.println("first = " + strings.peekFirst());
        System.out.println("last = " + strings.peekLast());
        System.out.println(strings.pop());
        strings.push("4");
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println("size = " + strings.size());
        System.out.println(strings.isEmpty());
    }

    private static void testQueueBasedOnDeque(Deque<String> strings) {
        strings.offer("1");
        strings.offer("2");
        strings.offer("3");
        System.out.println("size = " + strings.size());
        System.out.println(strings.isEmpty());
        System.out.println(strings.peek());
        System.out.println("first = " + strings.peekFirst());
        System.out.println("last = " + strings.peekLast());
        System.out.println(strings.poll());
        strings.offer("4");
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println("size = " + strings.size());
        System.out.println(strings.isEmpty());
    }

    private static void testQueue(Queue<String> strings) {
        strings.offer("1");
        strings.offer("2");
        strings.offer("3");

        System.out.println("size = " + strings.size());
        System.out.println(strings.peek());
        System.out.println(strings.poll());
        System.out.println(strings.peek());
        System.out.println(strings.poll());
        System.out.println(strings.peek());
        System.out.println(strings.poll());
        System.out.println(strings.peek());
        System.out.println(strings.poll());
        System.out.println(strings.peek());
        System.out.println(strings.isEmpty());

        System.out.println("size = " + strings.size());
        strings.offer("10");
        strings.offer("20");
        strings.offer("30");

        System.out.println(strings.peek());
        System.out.println(strings.poll());

        System.out.println(strings.isEmpty());
        System.out.println("size = " + strings.size());
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

        System.out.println("---------------------");

        Deque<String> strings = new ArrayDeque<>();
        strings.offer("1");
        strings.offer("2");
        strings.offer("3");
        strings.push("10");

        System.out.println(strings.peek());
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
