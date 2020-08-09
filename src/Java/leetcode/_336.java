package Java.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * failed
 *
 * @Author: kp1nz
 * @Date: 2020/8/6 9:37 下午
 */
public class _336 {
    static class Node {
        //ch[i]的值，存的是下一个Node在List中的位置
        int[] ch = new int[26];
        int flag;

        public Node() {
            flag = -1;
        }
    }

    //第一个节点是root
    static List<Node> tree = new ArrayList<Node>();

    public static List<List<Integer>> palindromePairs(String[] words) {
        tree.add(new Node());
        int n = words.length;
        //构造字典树
        for (int i = 0; i < n; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ret = new ArrayList<>();
        //遍历每个单词
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            //遍历每个字符
            for (int j = 0; j <= m; j++) {
                //如果从j往后是回文
                if (isPalindrome(words[i], j, m - 1)) {
                    //如果j之前的，在字典树中有逆序
                    int leftId = findWord(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                //相反的情况
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = findWord(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    //每个单词加入到字典树
    public static void insert(String s, int id) {
        int len = s.length(), add = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            //如果还没加过这个节点
            if (tree.get(add).ch[x] == 0) {
                tree.add(new Node());
                //指向新加的Node（在末尾）
                tree.get(add).ch[x] = tree.size() - 1;
            }
            //add向后指，继续添加字符
            add = tree.get(add).ch[x];
        }
        //add最后所在Node的flag，标记是哪个单词
        tree.get(add).flag = id;
    }

    //String的left~right是否为回文
    public static boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    //String的left~right是否在字典树中
    public static int findWord(String s, int left, int right) {
        int add = 0;
        //这里是逆序查询
        for (int i = right; i >= left; i--) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).flag;
    }


    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
    }
}
