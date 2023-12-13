package week13;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Node implements Comparable<Node> {
    public int v;
    public int e;

    public Node(int val, int end) {
        v = val;
        e = end;
    }


    @Override
    public int compareTo(Node o) {
        if (this.v != o.v) {
            return Integer.compare(this.v, o.v);
        } else {
            return Integer.compare(this.e, o.e);
        }
    }
}

class Resultt {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int b = edge.get(0);
            int e = edge.get(1);
            int w = edge.get(2);
            adj.get(b).add(new Node(w, e));
            adj.get(e).add(new Node(w, b));
        }

        int[] marked = new int[n + 1];
        Arrays.fill(marked, Integer.MAX_VALUE);
        marked[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, s));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (marked[node.e] >= node.v) {
                for (Node x : adj.get(node.e)) {
                    if (marked[x.e] > node.v + x.v) {
                        marked[x.e] = node.v + x.v;
                        pq.add(new Node(marked[x.e], x.e));
                    }
                }
            }

        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (marked[i] == Integer.MAX_VALUE) {
                res.add(-1);
            } else if (i != s) {
                res.add(marked[i]);
            }
        }

        return res;
    }

}

public class Dijkstra {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            if (st == null || !st.hasMoreElements ()) {
                do {
                    try {
                        st = new StringTokenizer (br.readLine ());
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                } while (st == null || !st.hasMoreElements ());
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader in=new FastReader();//creating the object
        int t1=in.nextInt();//taking input of the number of testcases to be solved
        for(int gj=0;gj<t1;gj++){//taking input of hte odes ad edges
            int n=in.nextInt();
            int m=in.nextInt();
            long w[][]=new long [n+1][n+1];
            for (long[] row: w)
                Arrays.fill(row, 1000000l);
            IntStream.range (0, m).forEach (i -> {
                int x = in.nextInt (), y = in.nextInt ();
                long cmp = in.nextLong ();
                if (w[x][y] > cmp) {
                    w[x][y] = cmp;
                    w[y][x] = cmp;
                }
            });
            Stack <Integer> t=new Stack<Integer>();
            int src=in.nextInt();
            for(int i=1;i<=n;i++){
                if(i!=src){t.push(i);}}
            Stack <Integer> p=new Stack<Integer>();
            p.push(src);
            w[src][src]=0;
            if (!t.isEmpty ()) {
                do {
                    int min = 989997979, loc = -1;
                    for (int i = 0; i < t.size (); i++) {
                        w[src][t.elementAt (i)] = Math.min (w[src][t.elementAt (i)], w[src][p.peek ()] + w[p.peek ()][t.elementAt (i)]);
                        if (w[src][t.elementAt (i)] <= min) {
                            min = (int) w[src][t.elementAt (i)];
                            loc = i;
                        }
                    }
                    p.push (t.elementAt (loc));
                    t.removeElementAt (loc);
                } while (!t.isEmpty ());
            }
            int i=1;
            while (i<=n) {
                if(i!=src && w[src][i]!=1000000l){System.out.print(w[src][i]+" ");}
                else if(i!=src){System.out.print("-1"+" ");}
                i++;
            }
            System.out.println();
        }
    }
}