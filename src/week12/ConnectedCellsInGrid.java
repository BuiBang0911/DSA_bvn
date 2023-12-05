package week12;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    public static int count_connected(int i, int j, List<List<Integer>> matrix) {

        if (i < 0 || j < 0 || i >= matrix.size() || j >= matrix.get(i).size() || matrix.get(i).get(j)==0) {
            return 0;
        }
        int cnt = 1;
        matrix.get(i).set(j, 0);

        cnt += count_connected(i - 1, j - 1, matrix);
        cnt += count_connected(i - 1, j, matrix);
        cnt += count_connected(i - 1, j + 1, matrix);
        cnt += count_connected(i, j - 1, matrix);
        cnt += count_connected(i, j + 1, matrix);
        cnt += count_connected(i + 1, j - 1, matrix);
        cnt += count_connected(i + 1, j, matrix);
        cnt += count_connected(i + 1, j + 1, matrix);

        return cnt;
    }
    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int res = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                res = Math.max(res, count_connected(i, j, matrix));
            }
        }
        return res;
    }

}

public class ConnectedCellsInGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Resultt.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

