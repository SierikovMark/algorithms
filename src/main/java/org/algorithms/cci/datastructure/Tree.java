package org.algorithms.cci.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;
    private int size;

    public Tree() {}

    public void add(T value) {
        size++;
        if (root == null) {
            root = new Node<>(value);
        } else {
            Node<T> prevNode = null;
            Node<T> node = root;
            while (node != null) {
                prevNode = node;
                if (node.getValue().compareTo(value) > 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            if (prevNode.getValue().compareTo(value) > 0) {
                prevNode.left = new Node<>(value);
            } else {
                prevNode.right = new Node<>(value);
            }
        }
    }

    public boolean isPresent(T value) {
        Node<T> node = root;
        while (node != null) {
            if (node.getValue().compareTo(value) == 0) {
                return true;
            } else if (node.getValue().compareTo(value) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    public boolean remove(T value) {
        Node<T> prevNode = null;
        Node<T> node = root;
        while (node != null) {
            if (node.getValue().compareTo(value) == 0) {
                size--;
                Queue<Node<T>> nodes = new LinkedList<>();
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                if (prevNode != null) {
                    if (isLeftNode(prevNode, node)) {
                        prevNode.left = null;
                    } else {
                        prevNode.right = null;
                    }
                } else {
                    root = null;
                    size = 0;
                }
                while (!nodes.isEmpty()) {
                    Node<T> pollNode = nodes.poll();
                    add(pollNode.getValue());
                    if (pollNode.left != null) {
                        nodes.add(pollNode.left);
                    }
                    if (pollNode.right != null) {
                        nodes.add(pollNode.right);
                    }
                }
                return true;
            }
            prevNode = node;
            if (node.getValue().compareTo(value) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    private boolean isLeftNode(Node<T> parent, Node<T> node) {
        return parent.getValue().compareTo(node.getValue()) < 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "Empty Tree";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size-- > 0) {
                Node<T> node = nodes.poll();
                stringBuilder.append(node.getValue());
                stringBuilder.append(" ");
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static class Node<T extends Comparable<T>> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        System.out.println(tree.isEmpty());
        System.out.println(tree.getSize());

        tree.add(4);
        tree.add(2);
        tree.add(6);
        tree.add(7);

        System.out.println(tree.isPresent(99));
        System.out.println(tree.isPresent(6));
        System.out.println(tree.isPresent(4));
        System.out.println(tree.isPresent(7));
        System.out.println(tree.isPresent(2));

        System.out.println(tree.isEmpty());
        System.out.println(tree.getSize());

        System.out.println("----------------------------------------");
        System.out.println(tree);
        System.out.println("----------------------------------------");

        System.out.println(tree.remove(4));
        System.out.println(tree.getSize());

        System.out.println("----------------------------------------");
        System.out.println(tree);
        System.out.println("----------------------------------------");
    }
}
