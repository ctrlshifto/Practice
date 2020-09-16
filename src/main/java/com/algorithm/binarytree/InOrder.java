package com.algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author WhomHim
 * @description 给定一个二叉树，返回它的中序遍历。
 * <p>中序遍历是先遍历左子树，然后访问根节点，然后遍历右子树。</p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
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

    /**
     * 不用递归的中序遍历
     *
     * @param root TreeNode
     * @return List<Integer>
     */
    private static List<Integer> inorderTraversalWithNoRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> linkList = new LinkedList<>();
        LinkedList<Integer> returnList = new LinkedList<>();

        while (root != null || !linkList.isEmpty()) {
            while (root != null) {
                linkList.push(root);
                root = root.left;
            }
            root = linkList.pop();
            returnList.add(root.val);
            root = root.right;
        }
        return returnList;
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

        TreeNode tn2 = new TreeNode(3)
                .setLeft(new TreeNode(6))
                .setRight(null);
        TreeNode tn3 = new TreeNode(2)
                .setLeft(new TreeNode(4))
                .setRight(new TreeNode(5));
        TreeNode tn = new TreeNode(1)
                .setLeft(tn3)
                .setRight(tn2);

        List<Integer> output = inorderTraversalWithNoRecursive(tn);
        System.out.println(output);

    }
}
