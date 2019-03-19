package kyu_6p;

/**
 * 判断一个字符串是否包含全部字母表的字母
 * @author kp1nz
 * @create 2019-02-14 22:35
 */
public class Check_alphabet {
    public static boolean check(String sentence){
        String alphabet = "qwetyuiopasdfghjklzxcvbnm";
        for (int i = 0;i<alphabet.length()-1;i++){
            if(sentence.toLowerCase().contains(alphabet.substring(i,i+1)))continue;
            else return false;
        }return true;
    }

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";
        System.out.println(check(sentence));
    }
}
