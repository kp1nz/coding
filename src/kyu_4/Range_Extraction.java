package kyu_4;

import java.util.Iterator;

/**
 * @author kp1nz
 * @create 2019-03-25 16:10
 */
public class Range_Extraction {

    static class ByteInfo {
        int start;
        int end;
        int temp;
    }

    public static String rangeExtraction(int[] arr) {
        StringBuilder sb = new StringBuilder();

        ByteInfo bi =new ByteInfo();
        for (int i = 0;i<arr.length;i++){

            bi.start = arr[i];
            if (bi.start<bi.end){

                for (int j = i+1;j<arr.length-1;j++){
                    bi.temp = arr[i];
                    if (arr[j] == bi.temp +1){
                        bi.temp = arr[j];
                    }else {
                        bi.end = arr[j];
                    }
                }
                sb.append(bi.start).append("-").append(bi.end).append(",");
            }
        }





        System.out.println(bi.start);
        System.out.println(bi.end);
//            System.out.println(bi.temp);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(rangeExtraction(
                new int[] {-3,-2,-1,2,10,15,16,18,19,20}
                ));
    }


}
