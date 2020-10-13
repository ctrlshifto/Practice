package com.algorithm;

import com.algorithm.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-10-13 22:51:39
 */
public class Offer55 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        //存放每一层的节点数
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int levelNodes = queue.size();

            // 不断的遍历队列，将每一层的元素放进队列
            for (int i = 0; i < levelNodes; ++i) {
                TreeNode treeNode = queue.remove();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            maxDepth++;
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(20)
                .setLeft(new TreeNode(15))
                .setRight(new TreeNode(7));

        TreeNode treeNode = new TreeNode(3)
                .setRight(treeNode2)
                .setLeft(new TreeNode(9));

        int maxDepth = maxDepth(treeNode);
        System.out.println(maxDepth);
    }
}
