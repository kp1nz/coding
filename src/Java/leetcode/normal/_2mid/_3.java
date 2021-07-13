package Java.leetcode.normal._2mid;

import java.util.HashMap;

/**
 * @Author: kp1nz
 * @Date: 2020/8/2 11:17 下午
 */
public class _3 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> chars = new HashMap<>();
        int max = 0;
        int def = 0;
        int st = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!chars.containsKey(s.charAt(i))) {
                def++;
            } else {
                if (chars.get(s.charAt(i)) < st)
                    // 区间前重复
                    def++;
                else {
                    // 更新起始指针
                    st = chars.get(s.charAt(i));
                    def = i - st;
                }
            }
            max = Math.max(def, max);
            chars.put(s.charAt(i), i);
        }
        return max;
    }

    public static int lengthOfLongestSubstringBetter(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return 1;
        //记录字符所在的index
        int[] record = new int[128];
        int start = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i);
            start = Math.max(start, record[index] );
            max = Math.max(max, i - start + 1);
            record[index] = i + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringBetter("nm"));
    }
}
