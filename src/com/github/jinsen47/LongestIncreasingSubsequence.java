package com.github.jinsen47;

import com.github.jinsen47.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinsen on 15/11/6.
 */
public class LongestIncreasingSubsequence {
  public static int lengthOfLIS(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i : nums) {
      List<Integer> singleResult = new ArrayList<>();
      singleResult.add(i);
      result.add(singleResult);
    }
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (result.get(j).get(result.get(j).size() - 1) < nums[i] && ((result.get(j).size() + 1) > result.get(i).size())) {
          List<Integer> singleResult = new ArrayList<>();
          for (Integer ii : result.get(j)) {
            singleResult.add(ii);
          }
          singleResult.add(nums[i]);
          result.set(i, singleResult);
        }
      }
    }

    int ret = 0;
    for (List<Integer> single : result) {
      ArrayUtils.printArray(single);
      if (single.size() > ret) {
        ret = single.size();
      }
    }
    return ret;
  }

  public static void main(String [] args) {
    int[] test1 = {10,9,2,5,3,7,101,18};
    int[] test2 = {5,6,7,1,2,8};
    System.out.println(lengthOfLIS(test2));
  }

}
