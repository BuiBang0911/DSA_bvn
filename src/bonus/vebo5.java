package bonus;

import java.util.Scanner;

public class vebo5 {
    private static int n;
    private static int a[];
    private static int ST[] = new int[4 * n];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new int[n+5];
        ST = new int[4 * n + 5];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        build(1, 1, n);
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            if (x == 1) {
                int l = in.nextInt();
                int r = in.nextInt();
                System.out.println(get(1, 1, n, l, r));
            } else {
                int l = in.nextInt();
                int r = in.nextInt();
                update(1, 1, n, l, r);
            }
        }
    }

    public static void build(int id, int l, int r) {
        if (l == r) {
            ST[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(id*2, l, mid);
        build(id*2 + 1, mid+1, r);
        ST[id] = Math.min(ST[id*2], ST[id*2 + 1]);
    }

    public static void update(int id, int l, int r, int i, int v) {
        if (i < l || r < i) {
            return ;
        }
        if (l == r) {
            ST[id] = v;
            return ;
        }

        int mid = (l + r) / 2;
        update(id*2, l, mid, i, v);
        update(id*2 + 1, mid+1, r, i, v);

        ST[id] = Math.min(ST[id*2], ST[id*2 + 1]);
    }
    private static int get(int id, int l, int r, int u, int v) {
        if (v < l || r < u) {
            return 1999999999;
        }
        if (u <= l && r <= v) {
            return ST[id];
        }
        int mid = (l + r) / 2;
        return Math.min(get(id*2, l, mid, u, v), get(id*2 + 1, mid+1, r, u, v));
    }
}

