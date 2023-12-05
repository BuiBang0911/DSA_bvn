package bonus;

import java.util.PriorityQueue;
import java.util.Scanner;

public class vebo2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i <= k) {
                sum += a[i];
                p.add(a[i]);
            } else {
                sum += a[i];
                p.add(a[i]);
                sum -= p.poll();
            }
            System.out.print(sum + " ");
        }
    }

}
