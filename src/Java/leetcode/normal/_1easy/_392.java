package Java.leetcode.normal._1easy;

/**
 * @Author: kp1nz
 * @Date: 2020/7/28 12:12 上午
 */
public class _392 {
    public static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc", t = "bbaaaaaabaaca";
        System.out.println(isSubsequence(s, t));
    }
}
