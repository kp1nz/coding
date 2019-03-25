package kyu_4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an n x n array,
 * return the array elements arranged from outermost elements to the middle element,
 * traveling clockwise.
 * <p>
 * array = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * snail(array) #=> [1,2,3,6,9,8,7,4,5]
 *
 * @author kp1nz
 * @create 2019-03-20 15:29
 */
public class Snail_Sort {

    public static int[] snail(int[][] array) {
        // enjoy
        List<Integer> list = new LinkedList<Integer>();

        int time = 0;
        int rows = array.length;//行
        int cols = array[0].length;//列
        int j = 0;

        for (int n = 0; ; n++) {
            //上方
            for (j = n; j < cols - n; j++) {
                time++;
//                System.out.println(array[n][j]);
                list.add(array[n][j]);
            }
            if (time == rows * cols)
                break;
            //右侧
            for (j = n + 1; j < rows - n; j++) {
                time++;
//                System.out.println(array[j][cols - n - 1]);
                list.add(array[j][cols - n - 1]);
            }
            if (time == rows * cols)
                break;
            //下方
            for (j = cols - n - 2; j >= n; j--) {
                time++;
//                System.out.println(array[rows - n - 1][j]);
                list.add(array[rows - n - 1][j]);
            }
            if (time == rows * cols)
                break;
            //左侧
            for (j = rows - n - 2; j >= n + 1; j--) {
                time++;
//                System.out.println(array[j][n]);
                list.add(array[j][n]);
            }
            if (time == rows * cols)
                break;
        }

        int[] arr = new int[list.size()];
        Iterator iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            arr[i] = (int) iterator.next();
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {


        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] array1
                = {{1, 2, 3}
        };

        int[][] array2
                = {{1},
                {4},
                {7},
                {10}
        };

        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};

        int[] snail = snail(array);
        for (int i = 0; i < snail.length; i++) {
            System.out.print(snail[i]);
        }
    }
}
