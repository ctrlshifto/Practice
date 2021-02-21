package com.algorithm.binarytree;

import java.util.HashMap;

/**
 * @author WhomHim
 * @description <p> 剑指 Offer 07. 重建二叉树 </p>
 * @date Create in 2021/2/21 20:38
 */
public class Offer07 {
    static int[] preorder;
    static HashMap<Integer, Integer> dic = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Offer07.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    static TreeNode recur(int root, int left, int right) {
        // 递归终止
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        //右子树根节点 = (中序根节点坐标-中序左边界）+ 先序根节点坐标 + 1
        node.right = recur(root - left + i + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        final TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

}
