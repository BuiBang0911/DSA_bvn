package week11;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class MissingNumbers {
    class Result {

        /*
         * Complete the 'missingNumbers' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY arr
         *  2. INTEGER_ARRAY brr
         */

        public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
            // Write your code here
            List<Integer> result = new ArrayList<>();
            Map<Integer, Integer> amap = new HashMap<>();
            Map<Integer, Integer> bmap = new HashMap<>();
            for (int i = 0; i < brr.size(); i++) {
                if (!bmap.containsKey(brr.get(i))) {
                    bmap.put(brr.get(i), 1);
                } else bmap.put(brr.get(i), bmap.get(brr.get(i)) + 1);
            }
            for (int i = 0; i < arr.size(); i++) {
                if (!amap.containsKey(arr.get(i))) {
                    amap.put(arr.get(i), 1);
                } else amap.put(arr.get(i), amap.get(arr.get(i)) + 1);
            }
            Set<Integer> set = bmap.keySet();
            for (Integer key : set) {
                if (!amap.containsKey(key) && !result.contains(key)) {
                    result.add(key);
                } else if (bmap.get(key) > amap.get(key) && !result.contains(key)) {
                    result.add(key);
                }
            }
            Collections.sort(result);
            return result;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        List<Integer> result = Result.missingNumbers(arr, brr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

