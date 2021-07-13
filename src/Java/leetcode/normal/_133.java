package Java.leetcode.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dfs 复制图
 * 遍历的时候用字典记录访问点
 *
 * @Author: kp1nz
 * @Date: 2020/8/12 10:06 下午
 */
public class _133 {
    HashMap<Integer, Node> dic = new HashMap<>();
    HashMap<Integer, List<Node>> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors.size() == 0) return new Node(node.val, new ArrayList<>());
        dfs(node);
        for (int key : map.keySet()){
            List<Node> nebs = map.get(key);
            Node copy = dic.get(key);
            for(Node a : nebs){
                copy.neighbors.add(dic.get(a.val));
            }
        }
        return dic.get(node.val);
    }

    private void dfs(Node node) {
        for (Node n : node.neighbors) {
            if (!map.containsKey(n.val)) {
                Node temp = new Node(n.val, new ArrayList<>());
                dic.put(n.val, temp);
                map.put(n.val, n.neighbors);
                dfs(n);
            }
        }
    }

    // 大神的解法 清晰易懂
    public Node cloneGraph1(Node node) {
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    private Node dfs(Node node, Map<Node,Node> lookup) {
        if (node == null) return null;
        if (lookup.containsKey(node)) return lookup.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors)clone.neighbors.add(dfs(n,lookup));
        return clone;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
