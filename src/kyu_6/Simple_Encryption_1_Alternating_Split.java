package kyu_6;

/**
 * For building the encrypted string:
 * Take every 2nd char from the string, then the other chars, that are not every 2nd char, and concat them as new String.
 * Do this n times!
 *
 * Examples:
 *
 * "This is a test!", 1 -> "hsi  etTi sats!"
 * "This is a test!", 2 -> "hsi  etTi sats!" -> "s eT ashi tist!"
 * @author kp1nz
 * @create 2019-03-20 13:50
 */
public class Simple_Encryption_1_Alternating_Split {

    public static String encrypt(final String text, final int n) {
        // Your code here

        if (text == null) {
            return null;
        }
        if (text == "") {
            return "";
        }
        if (text.length() <= 0) {
            return text;
        }
        int times = n;
        String res = text;
        while (times > 0) {
            times--;
            res = encrypt(res);
        }
        return res;
    }

    public static String encrypt(String text) {
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        boolean isEven = false;
        for (int i = 0; i < chars.length; i += 1) {
            if (isEven) {
                sb.append(chars[i]);
            } else {
                sb1.append(chars[i]);
            }
            isEven = !isEven;
        }
        return sb.append(sb1).toString();
    }

    public static String decrypt(final String encryptedText, final int n) {
        // Your code here
        if (encryptedText == null) {
            return null;
        }
        if (encryptedText == "") {
            return "";
        }
        if (encryptedText.length() <= 0) {
            return encryptedText;
        }
        int times = n;
        String res = encryptedText;
        while (times > 0) {
            times--;
            res = decrypt(res);
        }
        return res;
    }

    public static String decrypt(String encryptedText) {
        String str1 = "";
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        str1 = encryptedText.substring(0, encryptedText.length() / 2 );
        str2 = encryptedText.substring(encryptedText.length() / 2, encryptedText.length());
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < chars2.length && j < chars1.length) {
            sb.append(chars2[i]).append(chars1[j]);
            i++;
            j++;
        }
        //补全当长度为奇数时剩余的字符
        for (;i<chars2.length;i++){
            sb.append(chars2[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(decrypt(" Tah itse sits!", 3));
    }
}
