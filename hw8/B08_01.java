package hw8;

import java.util.Stack;

import org.w3c.dom.Node;

public class B08_01 {
    public static class Stack<T> {
        private Node<T> top;

        private static class Node<T> {
            T value;
            Node<T> next;
            Node(T v, Node<T> n) {
                value = v;
                next = n;
            }
        }

        public void push(T x) {
            top = new Node<>(x, top);
        }

        public T pop() {
            if (top == null) return null;
            T v = top.value;
            top = top.next;
            return v;
        }

        public T peek() {
            return top == null ? null : top.value;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
