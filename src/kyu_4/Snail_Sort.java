package kyu_4;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kp1nz
 * @create 2019-03-20 15:29
 */
public class Snail_Sort {

    public static int[] snail(int[][] array) {
        // enjoy
        List<Integer> list = new LinkedList<Integer>();
        for (int x =0;x<array.length;x++){

            for (int y= 0;y<array[x].length;y++){

                System.out.print(array[x][y]+" ");

            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        snail(array);
    }
}
