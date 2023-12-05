package bonus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class vebo3 {
    public static class Pair implements Comparable {
        int num;
        int val;

        public Pair(int num, int val) {
            this.num = num;
            this.val = val;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Pair) {
                Pair obj = (Pair) o;
                return Integer.compare(this.val, obj.val);
            }
            return -9999999;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int cnt = 1;
        long sum = 0;
        int n = in.nextInt();
        for (int i =0; i < n - 1; i++) {
            int type = in.nextInt();
            if (type == 1) {
                int x = in.nextInt();
                Pair temp = new Pair(cnt++, x);
                pq.add(temp);
            } else if (type == 2) {
                cnt++;
                int x = in.nextInt();
                while (pq.size() - x + 1 > 0) {
                    pq.poll();
                }
            }
        }
        int crs = in.nextInt();
        if (pq.size() > crs) {
            ArrayList<Integer> arr = new ArrayList<>();
            while (!pq.isEmpty()) {
                Pair res = pq.poll();
                sum += res.val;
                arr.add(res.num);
            }
            System.out.println(sum);
            Collections.sort(arr);
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
        }
        else {
            System.out.println(-1);
        }
    }
}
