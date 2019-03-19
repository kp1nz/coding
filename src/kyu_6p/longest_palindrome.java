package kyu_6p;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author kp1nz
 * @create 2019-03-19 18:32
 */
public class longest_palindrome {
    public static int longestPalindrome(final String s) {
        if (s == "") {
            return 0;
        }
        int start , end;
        String maxSub ="";
        boolean isSearched=false;

        StringBuilder sb = new StringBuilder(s);
        String sbr = sb.reverse().toString();
        System.out.println(s);
        System.out.println(sbr);

        //找两个字符串最大子串
        for (end = s.length(); end >= 1; end--) {
            for (start = 0; start <= (s.length() - end); start++) {
                maxSub = s.substring(start, (start + end));

                //第三个条件判断是否为回文数
                if (sbr.indexOf(maxSub) != -1
                        &&maxSub.length()<sb.length()
                        &&s.indexOf(maxSub)+sbr.indexOf(maxSub)+maxSub.length()==s.length()) {
                    System.out.println("The max equals substring is :" + maxSub);
                    isSearched = true;
                }
            }
            if (isSearched) break;
        }
        return maxSub.length();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aa"));

    }
}
