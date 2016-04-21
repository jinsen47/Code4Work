package com.github.jinsen47;

/**
 * Created by Jinsen on 16/1/11.
 */
public class PalindromicInteger {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0 )) return false;
        int tar = 0;
        while(x > tar) {
            tar = tar * 10 + x % 10;
            x /= 10;
        }
        return (x == tar || x == tar/10);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
