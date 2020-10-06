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

//        testHeap();

        Graph<Integer> graph = new GraphStructure<>();

        System.out.println("size = " + graph.size());
        System.out.println("empty = " + graph.isEmpty());

        graph.add(1);
        graph.add(2);
        graph.add(3);
        graph.add(4);
        graph.add(5);
        graph.add(6);

        System.out.println("size = " + graph.size());
        System.out.println("empty = " + graph.isEmpty());

        graph.connect(1, 2);
        graph.connect(1, 3);
        graph.connect(1, 4);

        graph.connect(2, 3);

        graph.connect(2, 5);
        graph.connect(3, 5);
        graph.connect(4, 5);

        graph.connect(5, 6);

        System.out.println(graph.isConnected(5,6));
        System.out.println(graph.isConnected(1,5));
        System.out.println(graph.isConnected(1,6));
        System.out.println(graph.isConnected(3,1));

        System.out.println(graph.search(10));
        System.out.println(graph.search(1));

        java.util.List<Integer> neighbor = graph.getNeighbor(1);
        for (Integer integer : neighbor) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : graph) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println(graph.isConnected(5, 6));
        graph.disconnect(6, 5);
        System.out.println(graph.isConnected(5, 6));

        System.out.println();

        graph.remove(2);

        System.out.println(graph.isConnected(1, 2));
        System.out.println(graph.search(2));




    }

    private static void testHeap() {
        Heap<Integer> integers = new PriorityQueue<>(Integer::compareTo);

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
