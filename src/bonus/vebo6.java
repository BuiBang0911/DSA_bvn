package bonus;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    private static int size = 0;
    private static int[] pqueue = new int[1000000+5];

    private static void swap(int indexOne, int indexTwo) {
        int temp = pqueue[indexOne];
        pqueue[indexOne] = pqueue[indexTwo];
        pqueue[indexTwo] = temp;
    }

    public static int peek() {
        if (size == 0) throw new IllegalStateException();
        return pqueue[0];
    }

    public static int poll() {
        if (size == 0) throw new IllegalStateException();

        int item = pqueue[0];
        pqueue[0] = pqueue[size - 1];
        size--;
        int index = 0;
        while (2 * index + 1 < size) {
            int smallerChildIndex = 2 * index + 1;
            if (2 * index + 2 < size && pqueue[2 * index + 2] < pqueue[2 * index + 1]) {
                smallerChildIndex = 2 * index + 2;
            }

            if (pqueue[index] < pqueue[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }

        return item;
    }

    public static void add(int item) {
        //ensureCapacity();
        pqueue[size] = item;
        size++;

        int index = size - 1;
        while ((index - 1) / 2 >= 0 && pqueue[(index - 1) / 2] > pqueue[index]) {
            swap((index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        //MyPriorityQueue pqueue = new MyPriorityQueue();
        for (int i = 0; i < A.size(); i++) {
            add(A.get(i));
        }
        int cnt = 0;
        while(peek() < k && size > 1) {
            int x = poll();
            add(x + 2 * poll());
            cnt++;
        }
        if (size == 0 || peek() < k) return -1;
        return cnt;
    }

}

public class vebo6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(ATemp[i]);
            A.add(AItem);
        }

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

