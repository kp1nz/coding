package study;

import java.util.*;

/**
 * @author kp1nz
 * @create 2019-04-02 19:56
 */
public class ttt2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (input.hasNext()) {
            list.add(input.nextLine());
        }
        System.out.println("666");
        System.out.println(resolve(list));
    }

    public static String resolve(List<String> list) {
        String string =new String();
        List<Integer> list1 = new LinkedList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (Integer.valueOf(list.get(i))-'0'+48>0){
                list1.add(Integer.valueOf(list.get(i)));
            }
        }
        list1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        StringBuilder sb =new StringBuilder();
        for (int i = 0;i<list1.size();i++){
            sb.append(i).append(",");
        }
        if (sb.length()>0){
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }


}
