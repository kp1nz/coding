package kyu_4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author kp1nz
 * @create 2019-03-26 21:33
 */
public class RecoverSecretString {
    public static String recoverSecret(char[][] triplets) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        HashMap map = new HashMap();
        for(int i =0;i<triplets.length;i++){
            for (int j=0;j<triplets[i].length;j++){
                list.add((int)triplets[i][j]);
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        return null;
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
