package Java.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 *
 * @Author: kp1nz
 * @Date: 2021/1/11 下午3:43
 */
public class _1202 {
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs == null) return s;
        char[] chars = s.toCharArray();
        pairs.forEach(a->{
            Character tmp = null;
            tmp = chars[a.get(0)];
            chars[a.get(0)] = chars[a.get(1)];
            chars[a.get(1)] = tmp;
        });
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(smallestStringWithSwaps("dcab", new ArrayList<List<Integer>>(){{
            add(new ArrayList<Integer>(){{add(0);add(3);}});
            add(new ArrayList<Integer>(){{add(1);add(2);}});
            add(new ArrayList<Integer>(){{add(0);add(2);}});
        }}));
    }
}
