package kyu_5;

import java.util.Arrays;

/**
 * Kata.expandedForm(12); # Should return "10 + 2"
 * Kata.expandedForm(42); # Should return "40 + 2"
 * Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
 *
 * @author kp1nz
 * @create 2019-03-19 11:11
 */
public class Expanded_Form {
    public static String expandedForm(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }
            sb.append(chars[i]);
            for (int j = i; j < chars.length - 1; j++) {
                sb.append(0);
            }

            if (i < chars.length - 1)
                sb.append(" + ");

        }
        if (num > 10 && num % 10 == 0) {
            res = sb.substring(0, sb.length() - 3);
            return res;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(9000000));
        System.out.println(12%10);
    }
}