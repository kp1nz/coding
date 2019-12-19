package kyu_4;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/551f23362ff852e2ab000037/train/java
 * <p>
 * /3/
 * \7\ 4
 * 2 \4\ 6
 * 8 5 \9\ 3
 * <p>
 * longestSlideDown [[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]
 * // => 23
 *
 * @author kp1nz
 * @create 2019-03-27 14:56
 */
public class PyramidSlideDown {


    public static int longestSlideDown(int[][] pyramid) {
        // Code Goes Here..


        int i = 0;
        int res = 0;
        int index = 0;
        int index2 = 0;
        while (i < pyramid.length) {
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> list1 = new ArrayList<Integer>();
            //将元素存入list
            list.add(pyramid[i][index2]);
            if (i > 0) {
                list.add(pyramid[i][index2 + 1]);
//                if (index>0){
//                    list.add(pyramid[i][index-1]);
//                }
            }
            int max = list.stream().mapToInt((x) -> x).summaryStatistics().getMax();
            System.out.println(max);
            for (int j = 0; j < pyramid[i].length; j++) {
                list1.add(pyramid[i][j]);
            }
//            index = list1.indexOf(max);
            index2 = list1.lastIndexOf(max);
            res += max;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
        };
        int[][] b = new int[][]
                {{3},
                        {7, 4},
                        {2, 4, 6},
                        {8, 5, 9, 3}};
        System.out.println(longestSlideDown(a));
    }

}
