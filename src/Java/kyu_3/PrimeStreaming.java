package kyu_3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 *     int[] found = Primes.stream().skip(skip).limit(limit).toArray();
 *
 * https://www.codewars.com/kata/prime-streaming-nc-17/
 *
 * 进阶版
 *
 * https://www.codewars.com/kata/prime-streaming-pg-13/train/java
 *
 * @author kp1nz
 * @create 2019-04-01 14:33
 */
public class PrimeStreaming {

    public static IntStream stream() {
        List list =new LinkedList();
        boolean[] prime = getPrime(100);
        for (int i = 2; i < 100; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }
        IntStream iStream = (IntStream)list.stream();
        return iStream;


    }


    public static boolean[] getPrime(int n){
        //让数组位置与其大小相同
        boolean[] a =new boolean[n+1];
        for (int i = 0;i<a.length;i++){
            a[i]=true;
        }
        a[1] =false;
        //除2以外，所有可能的质因数都是奇数
        //所有因数都是成对出现的，且其中一个因数必然小于该数的开平方
        for (int i =2 ; i<=Math.floor(Math.sqrt(n));i++){
//            if (a[i]){
                for (int j = i;j<n;j++){
                    if (i*j<n)
                    a[i*j]=false;
                }
//            }
        }
        for (boolean aa :
                a) {
            System.out.print(aa+",");
        }
        System.out.println();
        return a;
    }

    public static void main(String[] args) {
//        int[] ints = PrimeStreaming.stream().skip(0).limit(3).toArray();
//        for (int a :
//                ints) {
//            System.out.print(a+",");
//        }

        boolean[] prime = getPrime(214748362);
        int count = 0;
        for (int i = 2; i < 214748362; i++) {
            if (prime[i]) {
                System.out.print(i+",");
            }
        }
    }
}
