package com.algorithm.binarytree;

import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhomHim
 * @description 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * <p>
 * @date Create in 2020-8-4 22:32:32
 */

@Accessors(chain = true)
@Setter
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class preOrder {
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(left);
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
        List<Integer> valList = preorderTraversal(treeNode);
        System.out.println(valList);
    }
}
