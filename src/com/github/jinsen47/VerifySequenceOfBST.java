package com.github.jinsen47;

import java.util.Arrays;

/**
 * Created by Jinsen on 16/4/11.
 */
public class VerifySequenceOfBST {
    public static boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        if (sequence.length == 1) return true;

        int root = sequence[sequence.length - 1];

        int leftSubIndex = 0;
        for (leftSubIndex = 0; leftSubIndex < sequence.length - 1; leftSubIndex++) {
            if (root < sequence[leftSubIndex]) {
                break;
            }
        }
        for (int i = leftSubIndex; i < sequence.length - 1; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        boolean left = true;
        if (leftSubIndex > 0) {
            left = verifySquenceOfBST(Arrays.copyOfRange(sequence, 0, leftSubIndex));
        }
        boolean right = true;
        if (leftSubIndex < sequence.length - 1) {
            right = verifySquenceOfBST(Arrays.copyOfRange(sequence, leftSubIndex, sequence.length - 1));
        }
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(verifySquenceOfBST(new int[]{4,6,7,8,5}));
    }
}
