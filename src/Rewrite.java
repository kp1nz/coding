import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-03-16 11:00
 */
public class Rewrite {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int N = in.nextInt();//表示本次用例包括多少个代娇阳的字符串
//            String str[] = new String[N];
//            for (int i = 0; i < N; i++) {
//                str[i] = in.next();
//            }
//            rewrite(str);
//            for (int i=0;i<N;i++){
//                System.out.println(str[i].toString());
//            }
//        }
        String a = "woooow";
        System.out.println(proofread_1(a));
    }

    private static String[] rewrite(String[] strings) {
        for (int i=0;i<strings.length;i++){
            strings[i]=proofread_1(strings[i]);
            strings[i]=proofread_2(strings[i]);
        }
        return strings;
    }

    private static String proofread_1(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i ++) {
            char charWord = str.charAt(i);
            int firstPosition = str.indexOf(charWord);
            int lastPosition = str.lastIndexOf(charWord);
            //
            if (firstPosition  == lastPosition || firstPosition == i ||firstPosition ==i-1) {
                sb.append(charWord);
            }
        }
        return sb.toString();
    }
    private static String proofread_2(String str){
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = 0; i < str.length(); i ++) {
            char charWord = str.charAt(i);
            int firstPosition = str.indexOf(charWord);
            int lastPosition = str.lastIndexOf(charWord);
            //
            if (firstPosition  == lastPosition-1 || firstPosition == i ||firstPosition ==i-1) {
                if (firstPosition == lastPosition -1){
                    count++;
                    if (count==3){
                        if (firstPosition  == lastPosition-1 || firstPosition == i){
                            continue;
                        }
                    }
                }sb.append(charWord);
            }
        }
        return sb.toString();
    }
}
