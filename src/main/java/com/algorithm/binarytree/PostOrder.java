package com.algorithm.binarytree;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2)
                .setLeft(new TreeNode(3))
                .setRight(null);
        TreeNode treeNode = new TreeNode(1)
                .setRight(treeNode2)
                .setLeft(null);
        List<Integer> valList = postOrderTraversal(treeNode);
        System.out.println(valList);
    }
}
