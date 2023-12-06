package bonus;

import java.util.*;
import java.util.PriorityQueue;

public class vebo1 {
    static PriorityQueue<Integer> maxPQ;
    static PriorityQueue<Integer> minPQ;

    private static void insert(int x) {
        if (minPQ.isEmpty() || x <= minPQ.peek()) {
            minPQ.offer(x);
        } else {
            maxPQ.offer(x);
        }
        update();
    }

    private static void get() {
        if (!minPQ.isEmpty()) {
            System.out.println(minPQ.peek());
        } else {
            System.out.println(0);
            ;
        }
    }

    private static void update() {
        if (minPQ.size() > maxPQ.size() + 1) {
            maxPQ.offer(minPQ.poll());
        } else if (maxPQ.size() > minPQ.size()) {
            minPQ.offer(maxPQ.poll());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxPQ = new PriorityQueue<>();
        minPQ = new PriorityQueue<>(Collections.reverseOrder());
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            insert(x);
        }
        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                insert(x);
            } else if (type == 2) {
                minPQ.poll();
                update();
            } else {
                get();
            }
        }
    }
}