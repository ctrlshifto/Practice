package com.algorithm;

import com.algorithm.binarytree.TreeNode;

/**
 * @author WhomHim
 * @description <P>https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/</P>
 * @date Create in 2021/2/8 23:44
 */
public class LeetCode114 {
    public static void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode rightTemp = root.right;

                //将 1 的左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;

                // 一直向右查找右子树 4
                TreeNode right = root.right;
                while (right.right != null) {
                    right = right.right;
                }

                //将原来的右子树接到左子树的最右边节点
                right.right = rightTemp;
                flatten(root.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(5)
                .setRight(new TreeNode(6));

        TreeNode treeNode2 = new TreeNode(2)
                .setLeft(new TreeNode(3))
                .setRight(new TreeNode(4));

        TreeNode treeNode = new TreeNode(1)
                .setRight(treeNode3)
                .setLeft(treeNode2);

        flatten(treeNode);
    }
}
