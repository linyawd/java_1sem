package hw9;

import java.util.*;

public class B09_02 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();       // кількість номерів
        int M = in.nextInt();       // кількість клієнтів
        double T1 = in.nextDouble();
        double T2 = in.nextDouble();
        double T3 = in.nextDouble();
        double T4 = in.nextDouble();

        Random random = new Random();

        double[] arrival = new double[M];
        arrival[0] = 0.0;
        for (int i = 1; i < M; i++) {
            double inter = T1 + random.nextDouble() * (T2 - T1);
            arrival[i] = arrival[i - 1] + inter;
        }

        PriorityQueue<Double> busyUntil = new PriorityQueue<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        double totalWait = 0.0;
        int nextClient = 0;
        double currentTime = 0.0;

        while (nextClient < M || !queue.isEmpty()) {
            double nextArrival = nextClient < M ? arrival[nextClient] : Double.POSITIVE_INFINITY;
            double nextDeparture = busyUntil.isEmpty() ? Double.POSITIVE_INFINITY : busyUntil.peek();

            if (nextDeparture <= nextArrival) {
                currentTime = nextDeparture;
                busyUntil.poll();
                if (!queue.isEmpty()) {
                    int clientIndex = queue.pollFirst();
                    double startTime = currentTime;
                    double wait = startTime - arrival[clientIndex];
                    totalWait += wait;
                    double service = T3 + random.nextDouble() * (T4 - T3);
                    busyUntil.add(startTime + service);
                }
            } else {
                currentTime = nextArrival;
                if (busyUntil.size() < N) {
                    double service = T3 + random.nextDouble() * (T4 - T3);
                    busyUntil.add(currentTime + service);
                } else {
                    queue.addLast(nextClient);
                }
                nextClient++;
            }
        }

        double averageWait = totalWait / M;
        System.out.printf("%.4f%n", averageWait);
    }
}
```
