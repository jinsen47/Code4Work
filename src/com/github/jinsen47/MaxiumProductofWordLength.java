package com.github.jinsen47;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jinsen on 15/12/21.
 */
public class MaxiumProductofWordLength {

    public static int maxProduct(String[] words) {
        boolean[][] target = new boolean[words.length][words.length];
        int product = 0;
        int[] masks = new int[words.length]; // alphabet masks

        for(int i = 0; i < masks.length; i++){
            for(char c: words[i].toCharArray()){
                masks[i] |= 1 << (c - 'a');
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].length() * words[j].length() < product) break;
                if (i + j < words.length + 1) {
                    target[i][j] = (masks[i] == masks[j]);
                    if (!target[i][j]) {
                        product = Math.max(words[i].length() * words[j].length(), product);
                    }
                } else {
                    break;
                }
            }
        }
        return product;
    }

    public static void main(String[] args) {

    }
}
