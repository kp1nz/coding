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
    public static boolean checkInclusion(String s1, String s2) {
        char[] chars = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 97] = 1;
        }
        int tmp = 0;
        for (int i = 0, j = 0; i < s2.length(); ) {
            char t = chars[s2.charAt(i) - 97];
            if (t == 1) {

                chars[s2.charAt(i) - 97] = 2;
            } else {
                if (i != 0) {
                    chars[s2.charAt(i - 1) - 97] = (char) tmp;
                }
            }
            tmp = t;
        }
        int sum = 0;
        for (char c : chars) {
            sum += c;
        }
        System.out.println(sum);
        if (sum == s1.length() * 2)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
