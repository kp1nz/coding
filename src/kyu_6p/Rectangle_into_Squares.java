package kyu_6p;

import java.util.*;

/**
 * 切割矩形成若干正方形
 *
 * @author kp1nz
 * @create 2019-03-07 11:36
 */
public class Rectangle_into_Squares {

    public static List<Integer> sqInRect(int lng, int wdth) {
        int l_side = (lng > wdth) ? lng : wdth;
        int s_side = (lng > wdth) ? wdth : lng;
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        while (s_side != 1 && s_side != 0) {
            res.add(s_side);
            s_side = l_side - s_side;
            l_side = l_side - s_side;
        }
        for (int i = 0; i < res.size(); i++) {
            sum += res.get(i) * res.get(i);
        }
        while (sum != lng * wdth) {
            res.add(1);
            sum += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = sqInRect(3, 2);
        Iterator it = res.iterator();
        while (it.hasNext())
            System.out.print(it.next());
    }
}
