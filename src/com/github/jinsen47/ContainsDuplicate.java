package com.github.jinsen47;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jinsen on 15/11/10.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        Set<Integer> result = new HashSet<>();
        for (int i : nums) {
            result.add(i);
        }
        if (result.size() != nums.length) {
            return true;
        } else {
            return false;
        }
    }
}
