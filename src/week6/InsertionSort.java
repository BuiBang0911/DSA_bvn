package week6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class InsertionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
    class Result {

        /*
         * Complete the 'insertionSort2' function below.
         *
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER_ARRAY arr
         */

        public static void exch(List<Integer> arr, int a, int b) {
            int tmp = arr.get(a);
            arr.set(a, arr.get(b));
            arr.set(b, tmp);
        }

        public static void insertionSort2(int n, List<Integer> arr) {
            // Write your code here
            for (int i = 1; i < n; i++) {
                int min = arr.get(i);
                for (int j = i; j >= 1; j--) {
                    if (arr.get(j) < arr.get(j-1)) {
                        exch(arr, j, j-1);
                    }
                }
                for (int j = 0; j < n; j++) {
                    System.out.print(arr.get(j) + " ");
                }
                System.out.println();
            }
        }

    }
}

