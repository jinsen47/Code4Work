package com.github.jinsen47;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jinsen on 15/12/23.
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int maxLength = 0;
        int[] mask = new int[128];
        List<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            //没有
            if (mask[c] == 0) {
                list.add(c);
                mask[c] = 1;
            } else {
                // 有了
                while(!list.isEmpty()) {
                    char cc = list.remove(0);
                    mask[cc] = 0;
                    if (cc == c) {
                        mask[c] = 1;
                        list.add(c);
                        break;
                    }
                }
            }
            if (maxLength <= list.size()) {
                maxLength = list.size();
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
