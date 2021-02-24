package com.algorithm.binarytree;
//剑指 Offer 34. 二叉树中和为某一值的路径
//        输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
//
//
//        示例:
//        给定如下二叉树，以及目标和 sum = 22，
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        返回:
//
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
//
//
//        提示：
//
//        节点总数 <= 10000
//        注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/

import java.util.LinkedList;
import java.util.List;

/**
 * @author WhomHim
 * @description <p>https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/</p>
 * @date Create in 2021/2/24 20:56
 */
public class Offer34 {
    static LinkedList<List<Integer>> returnList = new LinkedList<>();
    static LinkedList<Integer> pathList = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return returnList;
    }

    private static void recur(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        pathList.offerLast(root.val);
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            // 防止对象引用
            final LinkedList<Integer> linkedList = new LinkedList<>(pathList);
            returnList.add(linkedList);
        }
        recur(root.left, sum);
        recur(root.right, sum);
        // 回溯法模板
        pathList.removeLast();
    }

    public static void main(String[] args) {
        final TreeNode A = new TreeNode(5);
        final TreeNode B = new TreeNode(4);
        final TreeNode C = new TreeNode(8);
        final TreeNode D = new TreeNode(11);
        final TreeNode E = new TreeNode(13);
        final TreeNode F = new TreeNode(4);
        final TreeNode G = new TreeNode(7);
        final TreeNode H = new TreeNode(2);
        final TreeNode J = new TreeNode(5);
        final TreeNode K = new TreeNode(1);

        A.left = B;
        A.right = C;
        B.left = D;
        D.left = G;
        D.right = H;
        C.left = E;
        C.right = F;
        F.left = J;
        F.right = K;

        final List<List<Integer>> lists = pathSum(A, 22);
        System.out.println(lists);
    }
}
