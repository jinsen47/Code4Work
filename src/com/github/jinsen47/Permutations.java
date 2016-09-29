package com.github.jinsen47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jinsen on 16/4/14.
 */
public class Permutations {
    public static List<String> permutations(String source) {
        if (source == null || source.length() == 0) return null;
        List<String> outList = new ArrayList<>();
        char[] sourceList = source.toCharArray();
        Arrays.sort(sourceList);
        permutationCore(sourceList, 0, outList);
        HashMap<Integer, Integer> map = new HashMap<>();

        return outList;
    }

    public static void permutationCore(char[] source,int k, List<String> outList) {
        if (k == source.length - 1) {
            outList.add(new String(source));
        }
        for (int i = k; i < source.length; i++) {
            swap(source, i, k);
            permutationCore(source, k + 1, outList);
            swap(source, i, k);
        }
    }

    public static void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        List<String> out = permutations("abcd");
        for (String s: out) {
            System.out.println(s);
        }
    }
}
