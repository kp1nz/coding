package Java.leetcode.jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 *输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，操作返回 -1 )
 *
 * 队列特性：先进先出
 * 栈特性：先进后出
 *
 * stack1：维护存入的元素
 * stack2：维护要删的元素，在要删除的时候：
 *                  若stack2没有元素，从stack1中取pop到stack2中，
 *                  stack1也没有元素的时候返回-1
 * @Author: kp1nz
 * @Date: 2021/7/12 4:40 PM
 */
public class CQueue {
    Deque<Integer> stack1 = null;
    Deque<Integer> stack2 = null;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            if (stack1.isEmpty()){
                return -1;
            }else {
                stack2.add(stack1.pop());
                return stack2.pop();
            }
        }else {
            return stack2.pop();
        }
    }
}
