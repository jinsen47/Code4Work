package com.github.jinsen47.baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Jinsen on 16/9/20.
 */
public class MaxSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.next();
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            char curChar = 'a';
            for (char c : input.toCharArray()) {
                if (count == 0) {
                    count = 1;
                    curChar = c;
                } else {
                    if (curChar == c) {
                        count++;
                    } else {
                        if (map.containsKey((int)curChar)) {
                            int originCount = map.get((int) curChar);
                            if (originCount < count) {
                                map.put((int) curChar, count);
                            }
                        } else {
                            map.put((int) curChar, count);
                        }
                        curChar = c;
                        count = 1;
                    }
                }
            }
            int sum = 0;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                sum += e.getValue();
            }
            System.out.println(sum);
        }
    }
}
