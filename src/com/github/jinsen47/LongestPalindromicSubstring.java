package com.github.jinsen47;

/**
 * Created by Jinsen on 15/12/24.
 */
public class LongestPalindromicSubstring {
    private static int lo, maxLen;

    /**
     * my solution
     * @param s
     * @return
     */
    public static String longestPalindromeMy(String s) {
        if (s.length() == 0) return "";
        char[] cArray = s.toCharArray();
//        String maxLengthString = "";
        int begin = 0;
        int maxlen = 0;
        //遍历奇数回文情况
        for(int i = 0; i < cArray.length; i++) {
//            String tempString = s.substring(i, i + 1);
            int tempBegin = i;
            int tempMax = 1;
            int j = 0;

            // 遍历奇数回文;
            while((i - j >= 0) && (i + j < cArray.length)) {
                if(cArray[i-j] == cArray[i+j]) {
                    tempBegin = i-j;
                    tempMax = 2*j+1;
//                    tempString = s.substring(i-j, i+j+1);
                    j++;
                } else {
                    break;
                }
            }
            if (maxlen <= tempMax) {
                begin = tempBegin;
                maxlen = tempMax;
            }
            j = 0;
            // 遍历偶数回文
            while((i - j >=0 ) && (i+1+j < cArray.length)) {
                if (cArray[i-j] == cArray[i+1+j]) {
                    tempBegin = i-j;
                    tempMax = 2*j+2;
//                    tempString = s.substring(i-j, i+j+2);
                    j++;
                } else {
                    break;
                }
            }

//            if (maxLengthString.length() <= tempString.length()) maxLengthString = tempString;
            if (maxlen <= tempMax) {
                begin = tempBegin;
                maxlen = tempMax;
            }
        }
        return s.substring(begin, begin + maxlen);
    }

    public static String longestPalindromeTop(String s) {

        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(longestPalindromeMy("ccc"));
        System.out.println(System.currentTimeMillis() - begin + "ms");
        begin = System.currentTimeMillis();
        System.out.println(longestPalindromeTop("ccc"));
        System.out.println(System.currentTimeMillis() - begin + "ms");
    }
}
