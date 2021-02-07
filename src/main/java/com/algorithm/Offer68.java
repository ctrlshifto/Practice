package com.algorithm;

import com.algorithm.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

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

        LinkedList<TreeNode> firstNodePath = new LinkedList<>();
        LinkedList<TreeNode> secondNodePath = new LinkedList<>();

        getPathToTarget(root, p, firstNodePath);
        getPathToTarget(root, q, secondNodePath);

        TreeNode node = null;
        int n = Math.min(firstNodePath.size(), secondNodePath.size());
        for (int i = 0; i < n; i++) {
            if (firstNodePath.get(i) == secondNodePath.get(i)) {
                node = firstNodePath.get(i);
            }
        }
        return node;
    }

    /**
     * 求二叉树根节点到指定节点的路径
     */
    static void getPathToTarget(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root == node) {
            return;
        }
        if (path.get(path.size() - 1) != node) {
            getPathToTarget(root.left, node, path);
        }
        if (path.get(path.size() - 1) != node) {
            getPathToTarget(root.right, node, path);
        }

        // 剪枝
        if (path.get(path.size() - 1) != node) {
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        final TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(2)
                .setLeft(new TreeNode(7))
                .setRight(treeNode5);

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
