package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/10 16:42
 */
public class Solution25_Reverse_Nodes_in_k_Group {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        if(k == 0 || k > len) return head;
        int totalTimes = len / k;
        ListNode pre = null;
        cur = null;
        ListNode next = head;
        ListNode fakeHead = new ListNode(0);
        ListNode lastTail = fakeHead;
        ListNode lastHead = head;
        int times = 0;
        while (next != null) {
            pre = cur;
            cur = next;
            next = next.next;
            cur.next = pre;
            times++;
            if(times == k) {
                totalTimes--;
                lastTail.next = cur;
                lastTail = lastHead;
                lastHead = next;
                if(totalTimes == 0) {
                    lastTail.next = next;
                    break;
                }
                pre = null;
                cur = null;
                times = 0;
            }
        }

        return fakeHead.next;
    }
}
