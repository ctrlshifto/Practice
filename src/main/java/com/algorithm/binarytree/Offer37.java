package com.algorithm.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WhomHim
 * @description <p>https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/</p>
 * @date Create in 2021/2/22 23:09
 */
public class Offer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder s = new StringBuilder();
        s.append(root.val)
                .append(",")
                .append(serialize(root.left))
                .append(",")
                .append(serialize(root.right));
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    public TreeNode dfs(Queue<String> queue) {
        String s = queue.poll();
        if ("null".equals(s) || s == null) {
            return null;
        }
        TreeNode tree = new TreeNode();
        tree.val = Integer.parseInt(s);
        tree.left = dfs(queue);
        tree.right = dfs(queue);
        return tree;
    }
}
