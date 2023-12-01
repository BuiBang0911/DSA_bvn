package week6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Resultt.insertionSort1(n, arr);

        bufferedReader.close();
    }
    class Resultt {

        /*
         * Complete the 'insertionSort1' function below.
         *
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER_ARRAY arr
         */

        public static void insertionSort1(int n, List<Integer> arr) {
            // Write your code here
            int x = arr.get(n-1);
            for (int i = n - 1; i >= 0; i--) {
                if ( i >= 1 && arr.get(i - 1) > x) {
                    arr.set(i, arr.get(i - 1));
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr.get(j) + " ");
                    }
                } else {
                    arr.set(i, x);
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr.get(j) + " ");
                    }
                    break;
                }
                System.out.println();
            }
        }

    }

}
