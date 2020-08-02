package Java.leetcode;

import java.util.ArrayList;
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
                // 更新起始指针
                st = i;
                if (chars.get(s.charAt(i)) + 1 != st) def++;
                else {
                    Integer index = chars.get(s.charAt(i));
                    def = i - index;
                }
            }
            max = Math.max(def, max);
            chars.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
