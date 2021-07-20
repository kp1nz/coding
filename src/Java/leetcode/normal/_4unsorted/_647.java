package Java.leetcode.normal._4unsorted;

/**
 * @Author: kp1nz
 * @Date: 2020/8/20 12:33 上午
 */
public class _647 {
    public int countSubstrings(String s) {
        int count = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (isPalindrom(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划
     * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为所给字符串的长度。
      */
    public int countSubstrings2(String s) {
        int count = 0, len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int i = -1; i > -len ; i--) {
            for (int j = 0; j < len + i; j++) {
                if (s.charAt(j) == s.charAt(j - i)) {
                    if (i == -1 || dp[j + 1][j - i - 1]) {
                        dp[j][j - i] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 分别计算长度为奇数和偶数的回文子串数量
     * 对于奇数回文串，从某个字符向两边扩张。
     * 对于偶数回文串，从某两个字符向两边扩张。
     * 时间复杂度在最差情况下是O(n ^ 2)，其中n为所给字符串的长度。空间复杂度是O(1)。
      */
    private static int result = 0;

    public static int countSubstrings3(String s) {
        for (int i = 0; i < s.length(); i++) {
            //回文串长度为奇数
            countSubstrings(s, i, i);
            //回文串长度为偶数
            countSubstrings(s, i, i + 1);
        }
        return result;
    }

    private static void countSubstrings(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            result++;
        }
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings3("aaa"));
    }


}
