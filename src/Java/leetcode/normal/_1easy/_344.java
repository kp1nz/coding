package Java.leetcode.normal._1easy;

/**
 * 反转字符串
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * @Author: kp1nz
 * @Date: 2021/7/14 9:49 AM
 */
public class _344 {
    public void reverseString(char[] s) {
        for(int start = 0, end = s.length - 1; start <= end;){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
