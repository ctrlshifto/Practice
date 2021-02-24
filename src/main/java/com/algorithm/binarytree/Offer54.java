package com.algorithm.binarytree;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/2/25 0:05
 */
public class Offer54 {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        // 计数，若 当前节点是第k个节点，结束递归，并记录 当前节点的值
        k = k - 1;
        final int i = k;
        if (i == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }


}
