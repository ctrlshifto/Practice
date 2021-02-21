package com.algorithm.binarytree;


import com.algorithm.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/2/9 21:51
 */
public class LeetCode116 {
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Node>> returnList = new ArrayList<>();

        LinkedList<Node> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            //获取当前队列的长度，这个长度相当于当前这一层的节点个数
            int levelNodes = queue.size();
            //遍历主要的作用是遍历每一层元素，让它们将下一层的元素放进队列
            List<Node> tmp = new ArrayList<>();
            for (int i = 0; i < levelNodes; ++i) {
                Node node = queue.remove();
                tmp.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            returnList.add(tmp);
        }
        for (List<Node> list : returnList) {
            for (int i = 0; i < list.size(); i++) {
                if (i + 1 < list.size()) {
                    if (list.get(i + 1) != null) {
                        Node node = list.get(i);
                        node.next = list.get(i + 1);
                    }
                }
            }
        }
        return root;
    }

    public static Node connectRecursive(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private static void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        // 连接不同父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }

    public static void main(String[] args) {
        Node treeNode3 = new Node(3)
                .setLeft(new Node(6))
                .setRight(new Node(7));

        Node treeNode2 = new Node(2)
                .setLeft(new Node(4))
                .setRight(new Node(5));

        Node treeNode = new Node(1)
                .setRight(treeNode3)
                .setLeft(treeNode2);

        connect(treeNode);
    }
}
