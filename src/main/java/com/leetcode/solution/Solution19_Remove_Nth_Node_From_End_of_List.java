package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 18:01
 */



public class Solution19_Remove_Nth_Node_From_End_of_List {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode prefix = new ListNode(-1);
        ListNode prefix_node = new ListNode(-1);
        prefix.next = prefix_node;
        prefix_node.next=head;

        ListNode font = new ListNode(0);
        font.next = head;
        ListNode tail = new ListNode(n-1);
        tail.next = head;
        for(int i=1;i<n-1;i++){
            tail.next = tail.next.next;
        }
        while(tail.next.next!=null){
            prefix.next=prefix.next.next;
            font.next=font.next.next;
            tail.next=tail.next.next;
        }
        prefix.next.next=font.next.next;
        font.next.next=null;


        return head;
    }


}
