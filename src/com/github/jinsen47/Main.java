package com.github.jinsen47;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int value = in.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = in.next();
            }
            System.out.println(solution(strings, value));
        }
    }

    public static int solution(String[] strings, int value) {
        int count = 0;
        for (String s : strings) {
            int singleCount = 1;
            for (int i = 1; i <= s.length(); i++) {
                String shift = shiftLeft(s, i);
                if (shift.equals(s)) {
                    singleCount++;
                }
            }
            if (singleCount == value) {
                count++;
            }
        }
        return count;
    }

    public static String shiftLeft(String str, int times) {
        LinkedList<Character> list = new LinkedList<>();
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        for (int i = 0; i < times; i++) {
            char c = list.remove(0);
            list.add(c);
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}