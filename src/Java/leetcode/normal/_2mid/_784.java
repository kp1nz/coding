package Java.leetcode.normal._2mid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * @Author: kp1nz
 * @Date: 2021/7/24 6:49 PM
 */
public class _784 {
    // ascii 0-9 == 48-57, A-Z == 65-90, a-z == 97-122
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> sb = new ArrayList<>();
        sb.add(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= 57) {
                for (StringBuilder str : sb) {
                    str.append(c);
                }
            } else {
                int size = sb.size();
                for (int j = 0; j < size; j++) {
                    sb.add(new StringBuilder(sb.get(j)));
                    sb.get(j).append(c);
                    sb.get(j+size).append((char)(c>90?c-32:c+32));
                }
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < sb.size(); i++) {
            res.add(sb.get(i).toString());
        }
        return res;
    }

    public static void main(String[] args) {
        _784 v = new _784();
        List<String> a1b2 = v.letterCasePermutation("a1b2");
        a1b2.forEach(System.out::println);
    }
}
