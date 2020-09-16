package com.algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WhomHim
 * @description 给定一个二叉树，返回它的 前序 遍历。
 * <p>前序遍历首先访问根节点，然后遍历左子树，最后遍历右子树。</p>
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
public class PreOrder {
    private static List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = preOrderTraversal(root.left);
        List<Integer> right = preOrderTraversal(root.right);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        return list;
    }

    /**
     * 迭代每一个节点
     * 不用递归的前序遍历
     *
     * @param root TreeNode
     * @return returnList
     */
    private static List<Integer> preOrderTraversalWithNoRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> linkList = new LinkedList<>();
        LinkedList<Integer> returnList = new LinkedList<>();

        linkList.add(root);
        while (!linkList.isEmpty()) {
            //拿链表最后面的元素出来
            TreeNode treeNode = linkList.pollLast();
            if (treeNode != null) {
                returnList.add(treeNode.val);
                if (treeNode.right != null) {
                    linkList.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    linkList.add(treeNode.left);
                }
            }
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

        List<Integer> valList = preOrderTraversal(treeNode);
        System.out.println(valList);

        List<Integer> output = preOrderTraversalWithNoRecursive(treeNode);
        System.out.println(output);
    }
}
