package com.github.jinsen47.bytedance;

import java.util.*;

/**
 * Created by Jinsen on 16/9/20.
 *
 * 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9 的数字，不同字符映射为不同的数字。这样每个字符串就可以看做一个整数，唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？

 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母 A-J 的字符串。 n 不大于 50，且至少存在一个字符不是任何字符串的首字母。

 * 输出描述:
 * 输出一个数，表示最大和是多少。

 * 输入例子:
 * 2
 * ABC
 * BCA

 * 输出例子:
 * 1875
 */
public class BiggestSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] inputs = new String[n];
            for (int i = 0; i < n; i++) {
                inputs[i] = in.next();
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (String s : inputs) {
                char[] array = s.toCharArray();
                int pow = array.length - 1;
                for (int i = 0; i < array.length; i++) {
                    int intValue = (int)array[i];
                    if (map.containsKey(intValue)) {
                        map.put(intValue, map.get(intValue) + (int)Math.pow(10, pow - i));
                    } else {
                        map.put(intValue, (int)Math.pow(10, pow - i));
                    }
                }
            }
            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet().size());
            entries.addAll(map.entrySet());
            Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            // TODO 排序之后可能有前导0 , 需要swap一下再求和
            int sum = 0;
            int base = 9;
            for (Map.Entry<Integer, Integer> e : entries) {
                sum += base-- * e.getValue();
            }
            System.out.println(sum);
        }
    }
}
