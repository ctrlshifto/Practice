package com.algorithm;

import com.algorithm.binarytree.TreeNode;


/**
 * @author WhomHim
 * @description https://leetcode-cn.com/problems/invert-binary-tree/
 * @date Create in 2021/2/8 22:07
 */
public class LeetCode226 {
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}


