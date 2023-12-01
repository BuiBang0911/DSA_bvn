package week8;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import static java.util.Collections.reverse;
import static java.util.Collections.sort;

public class FindTheRunningMedian {
class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int bn(List<Integer> a, int x) {
        int l = 0;
        int r = a.size() - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if(a.get(mid) == x) return mid;
            if(a.get(mid) > x){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> sol = new ArrayList<>();
        List<Double> cop = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            cop.add(1.0 * a.get(i));
        }
        sort(a);
        for (int i = a.size() - 1; i >= 0; i--) {
            if ((i + 1) % 2 == 0) {
                //01234
                sol.add((double) (a.get(i / 2) + a.get(i / 2 +1)) / 2.0 );
            } else {
                sol.add((double) a.get(i / 2));
            }
            int x = (int) (double) cop.get(i);
            a.remove(bn(a, x));
        }
        reverse(sol);
        return sol;
    }

}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = Result.runningMedian(a);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

