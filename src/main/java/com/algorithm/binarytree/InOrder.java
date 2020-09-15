package com.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;


/**
 * @author WhomHim
 * @description
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * @date Create in 2020-8-5 23:37:10
 */
public class InOrder {
    private static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        List<Integer> list = new ArrayList<>();
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2)
                .setLeft(new TreeNode(3))
                .setRight(null);
        TreeNode treeNode = new TreeNode(1)
                .setRight(treeNode2)
                .setLeft(null);
        List<Integer> valList = inorderTraversal(treeNode);
        System.out.println(valList);
    }
}
