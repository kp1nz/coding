package kyu_6p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 大整数（超int）乘法
 *
 * @author kp1nz
 * @create 2019-03-13 18:41
 */

public class Bigint_Multiply {
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(is);
        try {
            String data = read.readLine();
            System.out.println(multiply(data));
        } catch (IOException e) {
            System.out.println("输入有误。。");
            e.printStackTrace();
        }
    }
    public static String multiply(String data){
        String[] data2 = data.split(" ");
        char[] char1 = data2[0].toCharArray();
        char[] char2 = data2[1].toCharArray();//将大整数字符串转换为字符数组，以便于对单个数字进行操作；
        int[] int1 = new int[char1.length];
        int[] int2 = new int[char2.length];//用以存放int化大整数
        int[] res = new int[int1.length+int2.length];//用来存放计算结果；
        //将字符数组转换为整型数组
        for(int i = 0; i < char1.length; i++){
            int1[i] = char1[char1.length-1-i] - '0';
        }
        for(int i = 0; i < char2.length; i++){
            int2[i] = char2[char2.length-1-i] - '0';
        }
        //开始计算乘积
        for(int i = 0; i < int1.length; i++){
            for(int j = 0; j < int2.length; j++){
                res[i+j] += int1[i]*int2[j];
                if(res[i+j]>=10){//进位处理
                    res[i+j+1] += res[i+j]/10;
                    res[i+j] %= 10;
                }
            }
        }
        //将乘积转换为字符串
        StringBuffer result = new StringBuffer();
        for(int i = res.length-1;i >= 0; i--){
            if(i==res.length-1&&res[res.length-1]==0){//处理最高位是0的情况，其不应该显示
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }
}