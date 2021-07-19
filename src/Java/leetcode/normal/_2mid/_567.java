package Java.leetcode.normal._2mid;

/**
 * 567. 字符串的排列
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * @Author: kp1nz
 * @Date: 2021/7/16 5:17 PM
 */
public class _567 {
    // 小写字母97-122
    private static final char[] chars = new char[26];

    public static boolean checkInclusionBetter(String s1, String s2) {
        int n = s2.length();
        int[] dict = new int[26];
        int[] freq = new int[26];
        int size = 0;
        for (char c : s1.toCharArray()) {
            if (dict[c - 'a'] == 0) size++;
            dict[c - 'a']++;
        }
        int match = 0;
        int left = 0, right = 0;
        while (right < n) {
            char rc = s2.charAt(right);
            freq[rc - 'a']++;
            if (freq[rc - 'a'] == dict[rc - 'a']) match++;
            while (size == match) {
                if (right - left + 1 == s1.length()) return true;
                char lc = s2.charAt(left);
                freq[lc - 'a']--;
                if (freq[lc - 'a'] < dict[lc - 'a']) match--;
                left++;
            }
            right++;
        }
        return false;
    }

    public static boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 97] = 1;
        }
        int i = 0, j;
        while (i < s2.length() - s1.length() + 1) {
            char[] clone = chars.clone();
            j = i;
            while (j < s2.length()) {
                if (clone[s2.charAt(j) - 97] == 1 || clone[s2.charAt(j) - 97] == 2) {
                    clone[s2.charAt(j) - 97] = 2;
                    if (j - i + 1 >= s1.length() && check(clone)) {
                        return true;
                    }
                    j++;
                } else {
                    i = j + 1;
                    break;
                }
            }
            i = j + 1;
        }
        return false;
    }

    private static boolean check(char[] cs) {
        for (int a : cs) {
            if (a == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusionBetter("adc", "dcda"));
//        System.out.println(checkInclusion("ab", "eidbaooo"));
        /**
         * "adc"
         * "dcda"
         * "hello"
         * "ooolleoooleh"
         * "ab"
         * "eidbaooo"
         */
    }
}
