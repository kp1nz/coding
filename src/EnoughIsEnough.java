import java.util.*;

/**
 * Delete occurrences of an element if it occurs more than n times
 *
 * Given a list lst and a number N,
 * create a new list that contains each number of lst at most N times without reordering.
 * For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
 * drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times,
 * and then take 3, which leads to [1,2,3,1,2,3].
 * @author kp1nz
 * @create 2019-03-18 11:20
 */
public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map =new HashMap<Integer, Integer>();
        for (int element:
             elements) {
            if (map.containsKey(element)){
                int count = map.get(element);
                if (count<maxOccurrences){
                    list.add(element);
                    map.put(element,map.get(element)+1);
                }

            }else {
                list.add(element);
                map.put(element,1);
            }
        }
        int[] arr =new int[list.size()];
        int i =0;
        for (Integer a:
             list) {
                arr[i] = a;
                i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr;
        arr=deleteNth( new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3);
        for (int a :
             arr) {
            System.out.print(a+",");
        }
    }
}