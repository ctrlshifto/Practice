package com.algorithm.binarytree;

/**
 * @author WhomHim
 * @description <p>https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/</p>
 * @date Create in 2021/2/22 22:18
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp =  root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
