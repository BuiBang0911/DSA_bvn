package week5;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Stack<String> qu = new Stack<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String res = new String("");
        qu.add(res);
        for (int i = 0; i < n ;i++){
            int cnt = input.nextInt();
            res = qu.peek();
            if (cnt == 1) {
                //StringBuilder s = new StringBuilder(input.nextLine());
                String s = input.nextLine();
                //System.out.println(s);
                s = s.substring(1);
                //System.out.println(s);
                res = res + s;
                qu.add(res);
            } else if (cnt == 2) {
                int k = input.nextInt();
                //res.delete(res.length() - k, res.length());
                res = res.substring(0, res.length() - k);
                qu.add(res);
            } else if (cnt == 3) {
                int k = input.nextInt();
                System.out.println(qu.peek().charAt(k - 1));
            } else if (cnt == 4) {
                qu.pop();
            }
            //System.out.println(qu.peek());
        }
    }
}

