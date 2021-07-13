package kyu_4;


import java.util.LinkedList;
import java.util.List;

/**
 * 所有平衡括号
 * https://www.codewars.com/kata/all-balanced-parentheses/train/java
 *
 * @author kp1nz
 * @create 2019-04-01 12:34
 */
public class AllBalancedParentheses {

    public static List<String> balancedParens(int n) {
        // your code here
        List<String> list = new LinkedList<String>();
        getRes(n, n, "", list);
        return list;
    }

    public static void getRes(int left, int right, String str, List<String> list) {
        if (left<0||right<0||left>right){
            return;
        }
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        getRes(left - 1, right, str+("("), list);
        getRes(left, right - 1, str+(")"), list);
    }

    public static void main(String[] args) {
        List<String> list = balancedParens(3);
        for (String a :
                list) {
            System.out.print(a+",");
        }
    }

}
