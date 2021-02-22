package com.algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WhomHim
 * @description <p>https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/</p>
 * @date Create in 2021/2/22 23:27
 */
public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> returnList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            returnList.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        int[] array = new int[returnList.size()];
        for (int i = 0; i < returnList.size(); i++) {
            array[i] = returnList.get(i);
        }
        return array;
    }

}
