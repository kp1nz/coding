package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author kp1nz
 * @create 2019-04-02 18:45
 */
public class ttt {

    static class Time {
        private char word;
        private int times;
        public Time(char word, int times){
            this.times = times;
            this.word = word;
        }
    }



    public static int solution(String input) {
        if (input.length() == 0) return 0;
        Stack<Time> stack = new Stack<>();
        int count = 0;
        stack.push(new Time(input.charAt(0), 1));
        for (int i = 1; i < input.length(); i++) {
            char word = input.charAt(i);
            if (stack.peek().word == word)
                stack.peek().times ++;
            else
                stack.push(new Time(word, 1));
            if (stack.peek().times == 2 && stack.size() > 1) {
                Time top = stack.pop();
                if (stack.peek().times == 1) count++;
                stack.push(top);
            }
        }
        if (stack.peek().times == 1) count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s  = input.next();
        System.out.print(solution(s));
    }

}
