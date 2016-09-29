package com.github.jinsen47;

/**
 * Created by Jinsen on 16/9/22.
 */
public class BoyerMoore {

    public static int indexOf(String source, String target) {
        if (target == null || target.length() == 0) return -1;
        if (source.length() < target.length()) return -1;

        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        int max = sourceArray.length - targetArray.length;
        char first = targetArray[0];

        for (int i = 0; i <= max; i++) {
            // 找到第一个相等的
            if (sourceArray[i] != first) {
                while (++i <= max && sourceArray[i] != first);
            }

            if (i <= max) {
                int j = i + 1;
                int end = j + targetArray.length - 1;
                for (int k = 1; j < end && sourceArray[j] == targetArray[k]; k++, j++);
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String source = "BAAABCDA";
        String target = "ABC";
        System.out.println("My = " + indexOf(source, target));
        System.out.println("System = " + source.indexOf(target));
    }
}
