package week8;

import java.io.*;
import java.util.*;

public class Reverse {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String s = new StringBuilder(A).reverse().toString();
        if (A.equals(s)) {
            System.out.println("Yes");
        }
        else System.out.println("No");
    }
}




