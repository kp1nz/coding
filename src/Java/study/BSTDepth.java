package Java.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.BinaryOperator;

/**
 * @Author: kp1nz
 * @Date: 2020/8/21 15:08
 */
public class BSTDepth {

    // 递归
    public int computeTreeDepth(BinaryTree binaryTree){
        if(binaryTree == null){
            return 0;
        }
        return Math.max(computeTreeDepth(binaryTree.lChild), computeTreeDepth(binaryTree.rChild)) + 1;
    }

    // 广度优先
    public int computeTreeDepthBFS(BinaryTree binaryTree){
        //实例化队列
        Queue<BinaryTree> mVisitList = new LinkedList<>();
        BinaryTree tmp;
        int depth = 0, lengthTmp;
        if(binaryTree == null){
            //根为空，直接返回0
            return 0;
        }
        //将根加入队列
        mVisitList.offer(binaryTree);
        while (!mVisitList.isEmpty()){
            //只要队列不为空，说明新的一层数据不为空，且已经加到队列，深度+1
            depth ++;
            //遍历该层到所有数据，将他们出队，并附带把所有下一层到数据都加进来(如果有的话)
            lengthTmp = mVisitList.size();
            while (lengthTmp -- > 0){
                tmp = mVisitList.poll();
                if(tmp.lChild != null){
                    mVisitList.offer(tmp.lChild);
                }
                if(tmp.rChild != null){
                    mVisitList.offer(tmp.rChild);
                }
            }
        }
        return depth;
    }

    // 深度优先
    public static int computeTreeDepthDFS(BinaryTree binaryTree){
        //实例化栈
        Stack<BinaryTree> mVisitList = new Stack<>();
        BinaryTree tmp = binaryTree;
        //遍历过程中到最大深度
        int depth = 0;
        while (tmp != null){
            if(tmp.lChild != null || tmp.rChild != null){
                //如果有子树，将当前节点入栈，且更新最大深度
                mVisitList.push(tmp);
                depth = Math.max(depth, mVisitList.size());
                //因为是左子树优先，所以深度遍历下一个子节点的时候，优先左子树
                tmp = tmp.lChild != null ? tmp.lChild : tmp.rChild;
                continue;
            }
            //当前节点没有子树，直接更新最大深度（访问到当前节点到深度是栈的深度+1）
            depth = Math.max(depth, mVisitList.size() + 1);
            //此时回溯去找右子树
            while (!mVisitList.isEmpty()){
                if(mVisitList.peek().rChild != null){
                    //如果栈顶节点的右子树不为空，访问右子树
                    //访问的时候注意，如果栈顶节点的右子树等于当前正在访问的节点，应该置空避免没必要的循环
                    tmp = mVisitList.peek().rChild == tmp ? null : mVisitList.peek().rChild;
                    break;
                }
                //说明当前栈顶节点的右子树为空，直接出栈，继续回溯
                // 且要更新当前节点，用于记录当前正在回溯的节点，避免死循环回溯
                tmp = mVisitList.pop();
            }
        }
        return depth;
    }

    public static class BinaryTree{
        BinaryTree lChild, rChild;
        int value;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(BinaryTree lChild, BinaryTree rChild, int value) {
            this.lChild = lChild;
            this.rChild = rChild;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(new BinaryTree(new BinaryTree(3), null, 2), new BinaryTree(4), 1);
        System.out.println(computeTreeDepthDFS(binaryTree));
    }
}
