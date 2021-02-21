package com.algorithm.binarytree;

import com.algorithm.binarytree.TreeNode;

/**
 * @author WhomHim
 * @description <p>https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/</p>
 * @date Create in 2021-2-13 21:13:18
 */
public class Offer55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left)) {//如果左子树不平衡返回false
            return false;
        }
        if (!isBalanced(root.right)) {//如果右子树不平衡返回false
            return false;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        int abs = Math.abs(l - r);
        if (abs > 1) {
            return false;
        }
        return true;
    }


    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = maxDepth(node.left) + 1;
        int r = maxDepth(node.right) + 1;
        return Math.max(l, r);
    }

}
