package com.algorithm.binarytree;

import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-8-5 23:38:12
 */
@Accessors(chain = true)
@Setter
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
