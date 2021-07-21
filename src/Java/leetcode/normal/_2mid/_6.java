package Java.leetcode.normal._2mid;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * PAYPALISHIRING ==> PAHNAPLSIIGYIR
 *
 * @Author: kp1nz
 * @Date: 2021/7/15 2:53 PM
 */
public class _6 {

    public static String convert1(String s, int numRows) {
        if (numRows < 2) return s;
        ArrayList<StringBuilder> strs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            strs.add(new StringBuilder());
        }
        int row = 0, flag = -1;
        for (int i = 0; i < s.length(); i++) {
            if (row == 0 || row == numRows - 1)
                flag = -flag;
            strs.get(row).append(s.charAt(i));
            row += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder str : strs){
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 数学解法
     * numRows -> pox = 2(numRows - 2)*2+2=2numRows-2
     * numRows = 3
     * -->
     * 阶：pox = 4
     * 索引序列：index[] = (4i,4i+1,4i+2,4i+3)
     * i的取值范围 ： i = [0, (s.length-1)/4]
     * <p>
     * 0         4         8
     * 1    3    5   7   9
     * 2         6         10
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int length = s.length();
        char[] res = new char[length];
        int pox = (numRows - 2) * 2 + 1 + 1;
        int count = 0;
        //每行的第几个元素
        int index = 0;
        int row = 0;
        //是否有3，7这样的元素
        boolean flag = true;
        boolean flag2 = true;
        for (int i = 0; i < length; i++) {
            if (row == 0 || row == numRows - 1) {
                res[i] = s.charAt(pox * index + row);
                if (pox * (index + 1) + row >= length) {
                    index = 0;
                    row++;
                } else {
                    index++;
                }
            } else {
                if (index == 0 || flag) {
                    res[i] = s.charAt(pox * index + row);
                    flag = false;
                } else {
                    res[i] = s.charAt(pox * index - row);
                    flag = true;
                    if (pox * (index + 1) + row >= length) {
                        index = 0;
                        row++;
                    } else {
                        index++;
                    }
                }
            }
//            if (row != 0 && row != numRows - 1 && index != 0 && flag) {
//                res[i] = s.charAt(pox * index - row);
//                flag = !flag;
//                continue;
//            }
//            if (pox * index + row <= length)
//                res[i] = s.charAt(pox * index + row);
//            if (row != 0 && row != numRows - 1) {
//                if (pox * (index + 1) - row >= length){
//                    index = 0;
//                    row++;
//                }else {
//
//                }
//            } else {
//                if (pox * (index + 1) + row >= length) {
//                    index = 0;
//                    row++;
//                } else {
//                    index++;
//                }
//        }
//            count += 1;
//            flag = true;
        }
        return Arrays.toString(res).

                replaceAll("\\[|\\]|, ", "");

    }

    public static void main(String[] args) {
        System.out.println(convert1("PAYPALISHIRING", 3));
    }
}
