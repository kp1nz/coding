package Java.leetcode.normal._2mid;

/**
 * 5. 最长回文子串
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * @Author: kp1nz
 * @Date: 2021/7/13 4:25 PM
 */
public class _5 {
    public static String longestPalindrome(String s) {
        if (s == null && s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for (int end = 1; end < s.length(); end++) {
            for (int start = 0; start < end; start++) {
                // end - start <= 2 -> 'aba' & 'aa'
                if (s.charAt(start) == s.charAt(end) &&
                        (end - start <= 2 || dp[start+1][end -1])){
                    dp[start][end] = true;
                    if (end - start + 1 > maxLen) {
                        maxLen = end - start + 1;
                        maxStart = start;
                        maxEnd = end;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
