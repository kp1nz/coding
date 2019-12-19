package others;


import kyu_6p.Bigint_Multiply;

import java.math.BigInteger;

/**
 * OK Group笔试编程，求一个数的阶乘值后面有几个0
 *
 * @author kp1nz
 * @create 2019-04-01 18:46
 */
public class N1FindZero extends Bigint_Multiply {
    public static int resolve(int n){
        int res = 0;
        while (n!=0){
            n/=5;
            res +=n;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 20;
        long res =0;
        for (int i =1 ;i<=n;i++){
            res*=i;
        }
        System.out.println(res);
        System.out.println(resolve(20));
    }


}
