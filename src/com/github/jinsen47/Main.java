package com.github.jinsen47;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int t = in.nextInt();
            List<Boolean> results = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                boolean result = solution(in.nextInt(), in.nextInt(), in.nextInt());
                results.add(result);
            }
            for (int i = 0; i < results.size(); i++) {
                boolean b = results.get(i);
                System.out.println(String.format("Case #%d: ", i+1) + b);
            }
        }
    }

    public static boolean solution(int a, int b, int c) {
        long aLong = a;
        long bLong = b;
        long cLong = c;
        return aLong + bLong > cLong;
    }
}