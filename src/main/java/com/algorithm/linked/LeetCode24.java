package com.algorithm.linked;

/**
 * @author WhomHim
 * @description <p>https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/dong-hua-yan-shi-24-liang-liang-jiao-huan-lian-bia</p>
 * @date Create in 2021-2-14 15:35:42
 */
public class LeetCode24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode();
        }
        //假设链表是 1->2->3->4
        //保存 节点 2
        ListNode temp = head.next;
        //继续递归，处理节点3->4
        //当递归结束返回后，就变成了4->3
        //于是head节点就指向了4，变成1->4->3
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = swapPairs(node1);
        System.out.println(listNode);
    }
}
