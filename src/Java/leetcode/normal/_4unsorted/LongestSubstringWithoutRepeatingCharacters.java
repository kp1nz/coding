package Java.leetcode.normal._4unsorted;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 暴力解法超时O(n3)
 *
 * @author kp1nz
 * @create 2019-04-13 13:39
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        if (s==null||s.length()==0)return 0;
        int res =0;
        for (int L =0;L<s.length();L++){
            for (int R = L;R<s.length();R++){
                if (isLongest(L,R,s)){
                    res = res>R-L+1?res:(R-L+1);
                }
            }
        }return res;
    }
    public static boolean isLongest(int L,int R,String str){
        Set<Character> set = new HashSet<>();
            for (int i = L;i<=R;i++){
                if (!set.contains(str.charAt(i))){
                    set.add(str.charAt(i));
                }else return false;
            }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
