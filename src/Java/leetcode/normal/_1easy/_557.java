package Java.leetcode.normal._1easy;

/**
 * 557. 反转字符串中的单词 III
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * @Author: kp1nz
 * @Date: 2021/7/14 9:54 AM
 */
public class _557 {
    // 79.43% & 67.75%
    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word :
                split) {
            char[] chars = word.toCharArray();
            for (int start = 0, end = chars.length - 1; start <= end;) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }
            sb.append(chars).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(System.currentTimeMillis());
    }
}
