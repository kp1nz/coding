package study;

import java.util.HashMap;

/**
 * @author kp1nz
 * @create 2019-03-28 15:56
 */
public class LRUCache {

    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;//前节点
        DLinkedNode post;//后节点
    }

    private HashMap<Integer, DLinkedNode> cache
            = new HashMap<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    //弹出尾节点 不是tail是tail的前一个
    private DLinkedNode popTail() {
        DLinkedNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }

    //摘出来
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        //重置指针 将节点架空
        pre.post = post;
        post.pre = pre;
    }

    //moveToHead
    private void moveToHead(DLinkedNode node) {
        //摘出来
        removeNode(node);

        //将节点加入到头结点
        addNode(node);
    }

    //将节点加入到头结点
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }


    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; //cache里没有
        }
        //cache命中，挪到开头
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);

            //将节点加入到头结点
            addNode(node);
            ++count;

            if (count > capacity) {
                //最后一个节点弹出
                DLinkedNode tail = this.popTail();
                //remove key
                cache.remove(tail.key);
                count--;

            }

        } else {
            //cache命中,更新cache
            node.value = value;
            moveToHead(node);
        }
    }
}
