package org.algorithms.collections;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

public class BinaryTree<T> implements Tree<T> {

    private Node<T> root;
    private int size;
    private Comparator<T> comparator;

    private class Node<E> {
        E element;
        Node<E> leftChild;
        Node<E> rightChild;
        Node<E> parent;
    }

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public BinaryTree() {}

    @Override
    public void add(T element) {

        if (element == null) {
            throw new IllegalArgumentException("Element can't be null");
        }

        Node<T> newNode = new Node<>();
        newNode.element = element;

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        if (comparator != null) {
            findAndAddRecursivelyWithComparator(element, newNode, root);
        } else {
            if (!(element instanceof Comparable)) {
                throw new IllegalArgumentException("You have to specify comparator or elements should be comparable");
            }
            findAndAddRecursively(element, newNode, root);
        }
        size++;
    }

    private void findAndAddRecursivelyWithComparator(T element, Node<T> newNode, Node<T> currentNode) {
        if (comparator.compare(element, currentNode.element) < 0) {
            Node<T> leftChild = currentNode.leftChild;
            if (leftChild == null) {
                currentNode.leftChild = newNode;
                newNode.parent = currentNode;
            } else  {
                findAndAddRecursivelyWithComparator(element, newNode, leftChild);
            }
        } else if (comparator.compare(element, currentNode.element) > 0) {
            Node<T> rightChild = currentNode.rightChild;
            if (rightChild == null) {
                currentNode.rightChild = newNode;
                newNode.parent = currentNode;
            } else {
                findAndAddRecursivelyWithComparator(element, newNode, rightChild);
            }
        } else {
            System.out.println("Just ignore in current implementation");
        }
    }

    private void findAndAddRecursively(T element, Node<T> newNode, Node<T> currentNode) {
        if (((Comparable)element).compareTo(currentNode.element) < 0) {
            Node<T> leftChild = currentNode.leftChild;
            if (leftChild == null) {
                currentNode.leftChild = newNode;
                newNode.parent = currentNode;
            } else  {
                findAndAddRecursively(element, newNode, leftChild);
            }
        } else if (((Comparable)element).compareTo(currentNode.element) > 0) {
            Node<T> rightChild = currentNode.rightChild;
            if (rightChild == null) {
                currentNode.rightChild = newNode;
                newNode.parent = currentNode;
            } else {
                findAndAddRecursively(element, newNode, rightChild);
            }
        } else {
            System.out.println("Just ignore in current implementation");
        }
    }

    @Override
    public T remove(T element) {
        if (element == null) return null;

        org.algorithms.collections.Queue<Node<T>> queue = new LinkedListQueue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node<T> node = queue.poll();
            if (comparator == null) {
                if (((Comparable<T>)element).compareTo(node.element) == 0) {
                    deleteElement(node);
                    return node.element;
                } else {
                    if (node.leftChild != null) queue.offer(node.leftChild);
                    if (node.rightChild != null) queue.offer(node.rightChild);
                }
            } else {
                if (comparator.compare(element, node.element) == 0) {
                    deleteElement(node);
                    return node.element;
                } else {
                    if (node.leftChild != null) queue.offer(node.leftChild);
                    if (node.rightChild != null) queue.offer(node.rightChild);
                }
            }
        }
        return null;
    }

    private void deleteElement(Node<T> node) {
        Node<T> parent = node.parent;
        Node<T> leftChild = node.leftChild;
        Node<T> rightChild = node.rightChild;

        node.parent = null;

        boolean leftNode = isLeftNode(node, parent);
        if (leftChild == null && rightChild == null) {
            if (leftNode) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return;
        }

        if (leftChild != null && rightChild != null) {

            leftChild.parent = null;
            rightChild.parent = null;

            org.algorithms.collections.Queue<Node<T>> queue = new LinkedListQueue<>();
            queue.offer(leftChild);
            queue.offer(rightChild);

            BinaryTree<T> binaryTree = new BinaryTree<>();
            while (!queue.isEmpty()) {
                Node<T> poll = queue.poll();
                binaryTree.add(poll.element);
                if (poll.leftChild != null ) queue.offer(poll.leftChild);
                if (poll.rightChild != null ) queue.offer(poll.rightChild);
            }

            if (leftNode) {
                parent.leftChild = binaryTree.getRoot();
            } else {
                parent.rightChild = binaryTree.getRoot();
            }

        } else {
            if (leftChild != null) {
                if (leftNode) {
                    parent.leftChild = leftChild;
                } else {
                    parent.rightChild = leftChild;
                }
                return;
            } else {
                if (leftNode) {
                    parent.leftChild = rightChild;
                } else {
                    parent.rightChild = rightChild;
                }
            }
        }
    }

    private boolean isLeftNode(Node<T> node, Node<T> parent) {
        boolean leftNode;
        if (comparator == null) {
            leftNode = ((Comparable)node.element).compareTo(parent.element) < 0;
        } else {
            leftNode = comparator.compare(node.element, parent.element) < 0;
        }
        return leftNode;
    }

    @Override
    public T search(T element) {
        if (element == null || root == null) return null;

        T fundedElement;
        if (comparator == null) {
            fundedElement = findElement(element, root);
        }  else {
            fundedElement = findElementWithComparator(element, root);
        }
        return fundedElement;
    }

    private T findElementWithComparator(T element, Node<T> currentNode) {
        if (comparator.compare(element, currentNode.element) == 0) {
            return currentNode.element;
        } else {
            if (comparator.compare(element, currentNode.element) < 0) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
            if (currentNode == null) return null;
            return findElement(element, currentNode);
        }
    }

    Node<T> getRoot() {
        return root;
    }

    private T findElement(T element, Node<T> currentNode) {
        if (((Comparable)element).compareTo(currentNode.element) == 0) {
            return currentNode.element;
        } else {
            if (((Comparable)element).compareTo(currentNode.element) < 0) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
            if (currentNode == null) return null;
            return findElement(element, currentNode);
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Queue<Node<T>> queue = new ArrayDeque<Node<T>>() {{
                offer(root);
            }};

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                Node<T> currentNode = queue.poll();
                if (currentNode == null) throw new IllegalArgumentException();
                if (currentNode.leftChild != null) queue.offer(currentNode.leftChild);
                if (currentNode.rightChild != null) queue.offer(currentNode.rightChild);
                return currentNode.element;
            }
        };
    }

}
