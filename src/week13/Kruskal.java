package week13;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Comparator;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        ArrayList<Tree> l=new ArrayList<>();
        for(int i=0;i<gFrom.size();i++)
        {
            l.add(new Tree(gFrom.get(i),gTo.get(i),gWeight.get(i)));
        }
        Collections.sort(l);
        int r=doKruskal(l, gNodes,gFrom.size());
        return r;

    }

    public static int doKruskal(ArrayList<Tree> a,int v,int e)
    {
        //Subset[] s=new Subset[v+1];
        int[] s = new int[v+1];
        int result=0;
        for(int i=1;i<v+1;i++)
        {
            //s[i]=new Subset(i,0);
            s[i] = i;
        }
        for(int j=0;j<e;j++)
        {
            int x=findParent(s,a.get(j).s);
            int y=findParent(s,a.get(j).e);
            if(x!=y)
            {
                doUnion(s,x,y);
                result+=a.get(j).w;
            }
        }
        return result;
    }
    public static void doUnion(int[] p,int x,int y)
    {
        int a=findParent(p,x);
        int b=findParent(p,y);
        p[a] = b;
        /*if(p[a].r<=p[b].r)
        {
            p[a].p=b;
        }
        else
        {
            p[b].p=a;
        }*/
    }
    public static int findParent(int[] p,int i)
    {
        /*while (p[i] != i) {
            p[i] = i;
        }
        return p[i];*/
        if(p[i]==i)
        {
            return p[i];
        }
        return findParent(p,p[i]);
    }

}
class Tree implements Comparable<Tree>{
    int s;
    int e;
    int w;
    Tree(int x,int y,int z)
    {
        s=x;
        e=y;
        w=z;
    }
    @Override
    public int compareTo(Tree t)
    {
        if(this.w>t.w)
        {
            return 1;
        }
        else if(this.w<t.w)
        {
            return -1;
        }
        else
        {
            if((this.s+ this.e+this.w)<(t.s+t.e+t.w))
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

    }
    @Override
    public String toString()
    {
        return this.s+" "+this.e+" "+this.w;
    }
}
public class Kruskal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));

        bufferedReader.close();
        bufferedWriter.close();
    }
}

