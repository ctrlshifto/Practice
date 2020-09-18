package com.algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WhomHim
 * @description 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xebrb2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date Create in 2020-8-11 21:42:04
 */
public class PostOrder {
    private static List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = postOrderTraversal(root.left);
        List<Integer> right = postOrderTraversal(root.right);
        List<Integer> list = new ArrayList<>();

        list.addAll(left);
        list.addAll(right);
        list.add(root.val);
        return list;
    }

    private static List<Integer> postOrderTraversalWithNoRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> linkList = new LinkedList<>();
        LinkedList<Integer> returnList = new LinkedList<>();

        linkList.add(root);
        while (!linkList.isEmpty()) {
            //拿链表最后面的元素出来
            TreeNode treeNode = linkList.pollLast();
            //元素添加到链表头,就是因为这一步控制根节点‘1’输出在最后面
            returnList.addFirst(treeNode.val);
            if (treeNode.left != null) {
                //先进后出
                linkList.add(treeNode.left);
            }
            if (treeNode.right != null) {
                linkList.add(treeNode.right);
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
        List<Integer> valList = postOrderTraversal(treeNode);
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

        List<Integer> output = postOrderTraversalWithNoRecursive(tn);
        System.out.println(output);
    }

}
