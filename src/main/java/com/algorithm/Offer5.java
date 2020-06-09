package com.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author WhomHim
 * @description 从尾到头打印链表
 * @date Create in 2020/6/1 10:04
 */
public class Offer5 {

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        listNode1.next = listNode2;
        ArrayList<Integer> integers = printListFromTailToHead(listNode1);
        for (Integer integer : integers) {
            System.out.println("排序后顺序：" + integer);
        }
    }


    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            System.out.println("排序前顺序：" + listNode.val);
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop().val);
        }
        return list;
    }
}
