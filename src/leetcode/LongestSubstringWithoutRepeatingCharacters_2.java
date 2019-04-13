package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 滑动窗口
 * O(s*26/128)=O(n)
 *
 * @author kp1nz
 * @create 2019-04-13 13:39
 */

public class LongestSubstringWithoutRepeatingCharacters_2 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int[] freq = new int[128];//ascii表的最大表述范围
        int L = 0, R = -1;
        int res = 0;
        while (R < s.length()) {
            if (R == s.length() - 1)
                // 一定要break, 一是防止越界，二是不然L不会break；
                // R都到str.length - 1，L要再移动也不会更长了
                break;
            // 如果freq[chs[R + 1]] != 0，就要先一直移动L,
            // 直到freq[chs[R+1]]可以进入窗口，这个过程不会错过最优解
            if (freq[chs[R + 1]] == 0)
                freq[chs[++R]]++;
            else
                freq[chs[L++]]--;
            res = Math.max(res, R - L + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
