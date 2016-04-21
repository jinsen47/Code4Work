package com.github.jinsen47;

/**
 * Created by Jinsen on 15/12/25.
 */
public class ZigZagConvertion {
    public static String convert(String s, int numRows) {
        if (numRows <= 1 || s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            int count = 0;
            while(index < s.length()) {
                if (i == 0) {
                    sb.append(s.charAt(index));
                } else if (i == numRows - 1) {
                    if (index < numRows) {
                        sb.append(s.charAt(index));
                    } else if (index + numRows - 1 < s.length()) {
                        sb.append(s.charAt(index + numRows - 1));
                    }
                } else {
                    if (index < numRows) {
                        sb.append(s.charAt(index));
                    } else {
                        if (index - i > 0) {
                            sb.append(s.charAt(index - i));
                        }
                        if (index + i < s.length()) {
                            sb.append(s.charAt(index + i));
                        }
                    }
                }
                index = (++count) * (2 * numRows - 2);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("01234567", 3));
    }
}
