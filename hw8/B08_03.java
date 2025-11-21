package hw8;

import java.util.*;

public class B08_03 {
    public static class Graph {
        private HashMap<String, HashSet<String>> g = new HashMap<>();

        public void addVertex(String v) {
            g.putIfAbsent(v, new HashSet<>());
        }

        public void removeVertex(String v) {
            if (!g.containsKey(v)) return;
            for (String u : g.get(v)) g.get(u).remove(v);
            g.remove(v);
        }

        public void addEdge(String a, String b) {
            if (!g.containsKey(a)) addVertex(a);
            if (!g.containsKey(b)) addVertex(b);
            g.get(a).add(b);
            g.get(b).add(a);
        }

        public void removeEdge(String a, String b) {
            if (g.containsKey(a)) g.get(a).remove(b);
            if (g.containsKey(b)) g.get(b).remove(a);
        }

        public void print() {
            for (var e : g.entrySet()) {
                System.out.println(e.getKey() + " -> " + e.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Graph gr = new Graph();
        gr.addVertex("A");
        gr.addVertex("B");
        gr.addEdge("A", "B");
        gr.addEdge("A", "C");
        gr.removeEdge("A", "B");
        gr.print();
    }
}