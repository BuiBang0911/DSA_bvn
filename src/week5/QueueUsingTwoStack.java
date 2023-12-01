package week5;


import java.util.*;

public class QueueUsingTwoStack {

    public static void main(String[] args) {
        Queue<Integer> qu = new ArrayDeque<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n ;i++){
            int res = input.nextInt();;
            if (res == 1) {
                int x = input.nextInt();
                qu.add(x);
            } else if (res == 2) {
                qu.remove();
            } else if (res == 3) {
                System.out.println(qu.peek());
            }
        }
    }
}

