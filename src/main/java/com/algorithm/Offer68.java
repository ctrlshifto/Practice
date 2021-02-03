package com.algorithm;

import com.algorithm.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @author WhomHim
 * @description <p>https://leetcode-cn.com/classic/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/description/</p>
 * @date Create in 2021/2/3 22:28
 */
public class Offer68 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> linkList = new LinkedList<>();

        LinkedList<TreeNode> firstNodePath = new LinkedList<>();
        LinkedList<TreeNode> secondNodePath = new LinkedList<>();

        linkList.add(root);
        while (!linkList.isEmpty()) {
            //拿链表最后面的元素出来
            TreeNode treeNode = linkList.pollLast();
            if (treeNode != null) {
                if (!firstNodePath.contains(p)) {
                    firstNodePath.add(treeNode);
                }
                if (!secondNodePath.contains(q)) {
                    secondNodePath.add(treeNode);
                }

                if (treeNode.right != null) {
                    linkList.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    linkList.add(treeNode.left);
                }
            }
        }

        return firstNodePath.stream()
                .filter(firstNode -> secondNodePath.stream()
                        .anyMatch(secondNode -> firstNode == secondNode))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(2)
                .setLeft(new TreeNode(7))
                .setRight(new TreeNode(4));

        TreeNode treeNode3 = new TreeNode(1)
                .setLeft(new TreeNode(0))
                .setRight(new TreeNode(8));

        TreeNode treeNode2 = new TreeNode(5)
                .setLeft(new TreeNode(6))
                .setRight(treeNode4);

        TreeNode treeNode = new TreeNode(3)
                .setRight(treeNode3)
                .setLeft(treeNode2);

        final TreeNode parentTreeNode = lowestCommonAncestor(treeNode, treeNode2, treeNode3);
        System.out.println(parentTreeNode);
    }
}
