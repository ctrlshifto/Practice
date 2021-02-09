package com.algorithm;

import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/2/9 22:16
 */
@Accessors(chain = true)
@Setter
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
