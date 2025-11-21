package hw8;

import java.util.*;

public class B08_04 {
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        double dist() {
            return Math.sqrt(x * x + y * y);
        }
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(Point::dist));

        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            pq.add(new Point(x, y));
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
