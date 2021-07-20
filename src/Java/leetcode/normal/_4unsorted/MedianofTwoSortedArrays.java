package Java.leetcode.normal._4unsorted;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author kp1nz
 * @create 2019-04-13 17:13
 */
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        IntStream stream1 =  Arrays.stream(nums1);
        IntStream stream2 =  Arrays.stream(nums2);
        IntStream stream = IntStream.concat(stream1,stream2);

//        stream.forEach(System.out::println);
        IntStream sorted = stream.sorted();
//        sorted.forEach(System.out::println);
        int length =nums1.length+nums2.length;
        if (length%2==0){
            return sorted.skip(length/2-1).limit(2).sum()/2.0;
        }else
            return sorted.skip(length/2).limit(1).sum();
    }

    public static void main(String[] args) {
       int[]  num1 ={1,2};
       int[]  num2 ={3,4};
        System.err.println( findMedianSortedArrays(num1, num2));
    }
}
