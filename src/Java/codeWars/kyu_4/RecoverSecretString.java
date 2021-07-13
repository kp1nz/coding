package kyu_4;

import java.util.*;

/**
 * https://www.codewars.com/kata/53f40dff5f9d31b813000774/train/java
 *
 * ...
 *
 * @author kp1nz
 * @create 2019-03-26 21:33
 */
public class RecoverSecretString {
    public static String recoverSecret(char[][] triplets) {

        LinkedList<Character> list1 = new LinkedList<Character>();
        LinkedList<Character> list2 = new LinkedList<Character>();
        LinkedList<Character> list3 = new LinkedList<Character>();
        HashMap map = new HashMap();
        Set set = new HashSet();
        for (int i = 0; i < triplets.length; i++) {
            list1.add(triplets[i][0]);
            list2.add(triplets[i][1]);
            list3.add(triplets[i][2]);
        }
        get(list1, list2, list3);

        return null;
    }


    public static void get(List<Character> list1,
                           List<Character> list2,
                           List<Character> list3) {

        Stack stack = new Stack();
        for (int i = 0; i < list1.size(); i++) {
            if (!list2.contains(list1.get(i))) {
                stack.push(list1.get(i));
                list1.remove(list1.get(i));
                int i1 = list1.indexOf(list1.get(i));
        }
        }
        System.out.println(stack.pop());
        for (Character a :
                list1) {
            System.out.print(a);
        }
    }


    public static void main(String[] args) {
        recoverSecret(new char[][]{
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}});
    }

}
