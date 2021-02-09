package com.algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WhomHim
 * @description 二叉树的层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xefh1i/
 *
 * </p>
 * @date Create in 2020-10-9 22:52:30
 */
public class LevelOrder {
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            // 获取当前队列的长度，这个长度相当于当前这一层的节点个数
            int levelNodes = queue.size();

            List<Integer> tmp = new ArrayList<>();
            // 遍历主要的作用是遍历每一层元素，让它们将下一层的元素放进队列
            for (int i = 0; i < levelNodes; ++i) {
                TreeNode treeNode = queue.remove();
                tmp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            returnList.add(tmp);
        }

        return returnList;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(20)
                .setLeft(new TreeNode(15))
                .setRight(new TreeNode(7));
        TreeNode treeNode = new TreeNode(3)
                .setRight(treeNode2)
                .setLeft(new TreeNode(9));

        List<List<Integer>> valList = levelOrder(treeNode);
        System.out.println(valList);

    }
}
