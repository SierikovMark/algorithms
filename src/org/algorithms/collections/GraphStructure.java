package org.algorithms.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class GraphStructure<T> implements Graph<T> {

    private Map<Vertex<T>, List<Vertex<T>>> graph = new HashMap<>();

    private static class Vertex<E> {
        E element;

        Vertex(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?> vertex = (Vertex<?>) o;
            return Objects.equals(element, vertex.element);
        }

        @Override
        public int hashCode() {
            return Objects.hash(element);
        }
    }

    @Override
    public void add(T element) {
        Vertex<T> vertex = new Vertex<>(element);
        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new ArrayList<>());
        }
    }

    @Override
    public void remove(T element) {
        Vertex<T> vertex = new Vertex<>(element);
        if (graph.containsKey(vertex)) {
            List<Vertex<T>> vertices = graph.get(vertex);
            for (Vertex<T> currentVertex : vertices) {
                graph.get(currentVertex).remove(vertex);
            }
            graph.remove(vertex);
        }
    }

    @Override
    public void connect(T elementFirst, T elementSecond) {
        Vertex<T> vertexFirst = new Vertex<>(elementFirst);
        Vertex<T> vertexSecond = new Vertex<>(elementSecond);
        if (graph.containsKey(vertexFirst) && graph.containsKey(vertexSecond)) {
            graph.get(vertexFirst).add(vertexSecond);
            graph.get(vertexSecond).add(vertexFirst);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void disconnect(T elementFirst, T elementSecond) {
        Vertex<T> vertexFirst = new Vertex<>(elementFirst);
        Vertex<T> vertexSecond = new Vertex<>(elementSecond);
        if (graph.containsKey(vertexFirst) && graph.containsKey(vertexSecond)) {
            graph.get(vertexFirst).remove(vertexSecond);
            graph.get(vertexSecond).remove(vertexFirst);
        }
    }

    @Override
    public boolean isConnected(T elementFirst, T elementSecond) {
        Vertex<T> vertexFirst = new Vertex<>(elementFirst);
        Vertex<T> vertexSecond = new Vertex<>(elementSecond);
        if (graph.containsKey(vertexFirst) && graph.containsKey(vertexSecond)) {
            List<Vertex<T>> vertices = graph.get(vertexFirst);
            return vertices.contains(vertexSecond);
        }
        return false;
    }

    @Override
    public T search(T element) {
        Vertex<T> vertex = new Vertex<>(element);
        if (graph.containsKey(vertex)) {
            return element;
        }
        return null;
    }

    @Override
    public List<T> getNeighbor(T element) {
        return graph.get(new Vertex<>(element)).stream().map(Vertex::getElement).collect(Collectors.toList());
    }

    @Override
    public int size() {
        return graph.size();
    }

    @Override
    public boolean isEmpty() {
        return graph.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return graph.keySet().stream().map(Vertex::getElement).collect(Collectors.toList()).iterator();
    }
}
