package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/10 15:34
 */
public class Solution24_Swap_Nodes_in_Pairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode prefixNode =new ListNode(-1);
        ListNode prefixPoint =new ListNode(-1);
        prefixPoint.next = prefixNode;
        prefixNode.next=head;
        while(prefixNode!=null){
            swapNextTwoNodes(prefixNode);
            prefixNode=prefixNode.next;
            if(prefixNode!=null){
                prefixNode=prefixNode.next;
            }
        }
        return prefixPoint.next.next;

    }

    private void swapNextTwoNodes(ListNode node){
        if(node.next==null||node.next.next==null) return;

        ListNode firstPoint = new ListNode(-1);
        ListNode secondPoint = new ListNode(-1);

        firstPoint.next = node.next;
        secondPoint.next = node.next.next;

        //swap
        node.next = secondPoint.next;
        firstPoint.next.next = node.next.next;
        secondPoint.next.next = firstPoint.next;
    }

}
