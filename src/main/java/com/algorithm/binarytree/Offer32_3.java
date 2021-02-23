package com.algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/2/24 0:07
 */
public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int level = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> returnList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                if (level % 2 == 1) {
                    levelList.add(node.val);
                }
                if (level % 2 == 0) {
                    levelList.push(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
            returnList.add(levelList);
        }
        return returnList;
    }
}
